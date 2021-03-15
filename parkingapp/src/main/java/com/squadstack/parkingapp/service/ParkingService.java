package com.squadstack.parkingapp.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.squadstack.parkingapp.model.ParkingRecords;
import com.squadstack.parkingapp.model.ParkingRequest;
import com.squadstack.parkingapp.repo.ParkingRecordsRepository;
import com.squadstack.parkingapp.repo.ParkingRequestRepository;
import com.squadstack.parkingapp.mapper.*;
import com.squadstack.parkingapp.util.*;

@Service
public class ParkingService {

	@Autowired
	ParkingRequestRepository parkingReqRepo;

	@Autowired
	ParkingRecordsRepository parkingRecordsRepo;

	int size;
	Set<Integer> slots = new HashSet<Integer>();

	BufferedWriter writer;
	public void startParkingService(String inputFile, String outputFile) {
		try
		{
			parkingReqRepo.deleteAll();
			
			BufferedReader reader = ParkingAppUtil.getBufferedReader(inputFile);
			writer = ParkingAppUtil.getBufferedWriter(outputFile);
			writer.write("");
			String line = null;
			while ((line = reader.readLine()) != null) {
				executeCommand(line);
			}
			
			reader.close();
			writer.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

	public void executeCommand(String fullCommand) {
		String[] commandParams = fullCommand.split(" ");
		if (ParkingAppConstants.commandMap.containsKey(commandParams[0])) {
			switch (ParkingAppConstants.commandMap.get(commandParams[0])) {
			case 1: {
				createParking(Integer.valueOf(commandParams[1]));
				break;
			}
			case 2: {
				generateParkingTicket(commandParams[1], Integer.valueOf(commandParams[3]));
				break;
			}
			case 3: {
				removeParkedVehicle(Integer.valueOf(commandParams[1]));
				break;
			}
			case 4: {
				getSlotNumbersOfDriversAge(Integer.valueOf(commandParams[1]));
				break;
			}
			case 5: {
				getSlotNumberOfVehicle(commandParams[1]);
				break;
			}
			case 6: {
				getVehRegNumOfDriversAge(Integer.valueOf(commandParams[1]));
				break;
			}
			default: {
				commandNotValidErrorMsg(fullCommand);
			}
			}
		} else {
			commandNotValidErrorMsg(fullCommand);
		}
	}
	
	public void writeOutput(String output)
	{
		try {
			System.out.println(output);
			writer.write(output);
			writer.newLine();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public void commandNotValidErrorMsg(String cmd) {
		String output = "Command = " + cmd + " not valid. Please try a valid command";
		writeOutput(output);
	}

	public void createParking(int size) {
		this.size = size;
		for (int i = 1; i <= size; i++) {
			slots.add(i);
		}
		
		String output = "";
		output += "Created parking of "+ size + " slots";
		writeOutput(output);
	}

	public void generateParkingTicket(String veh_reg_num, int driversAge) {
		String output = "";
		if (slots.isEmpty()) {
			{				
				output += "No Parking Slots are available. Try again later";
			}
		} else {
			if (isVehAlreadyParked(veh_reg_num)) {
				output += "Given Vehicle Registration Number Already Parked. Alert!!";
			} else {

				ParkingRequest req = new ParkingRequest();
				req.setDriversAge(driversAge);
				req.setSlotNum(Collections.min(slots));
				req.setVehicleRegNum(veh_reg_num);
				req.setEntryTimeStamp(new Timestamp(new Date().getTime()));
				parkingReqRepo.save(req);
				
				output += "Car with vehicle registration number \"" + req.getVehicleRegNum()
						+ "\" has been parked at slot number " + req.getSlotNum();
				slots.remove(req.getSlotNum());				
			}
		}
		
		writeOutput(output);
	}

	public boolean isVehAlreadyParked(String veh_reg_num) {
		List<ParkingRequest> list = parkingReqRepo.findByVehRegNum(veh_reg_num);
		if (list == null || list.isEmpty())
			return false;
		else
			return true;
	}

	public void removeParkedVehicle(int slotNum) {
		String output = "";
		if (slots.size() == size) {
			output += "No vehicles are parked, all slots are empty";
		} else {
			if (slots.contains(slotNum)) {
				output += "Slot : " + slotNum + " already vacant";
			} else {
				if (slotNum > size) {
					output += "Slot : " + slotNum + " does not exist";			
				}
				else
				{
					ParkingRequest req = parkingReqRepo.findBySlotNum(slotNum).get(0);
					ParkingRecords record = Mapper.mapParkingRequestsToParkingRecords(req);
					slots.add(record.getSlotNum());
					record.setExitTimeStamp(new Timestamp(new Date().getTime()));
					parkingRecordsRepo.save(record);
					parkingReqRepo.delete(req);
					
					output += "Slot number " + slotNum + " vacated, the car with vehicle registration number \""
							+ record.getVehicleRegNum() + "\" left the space, the driver of the car was of age "
							+ record.getDriversAge();
				}
			}
		}
		
		writeOutput(output);
	}

	public void getSlotNumbersOfDriversAge(int age) {
		List<ParkingRequest> list = parkingReqRepo.findSlotNumByDriversAge(age);
		String output = "";
		for (ParkingRequest req : list) {
			output += req.getSlotNum() + ",";
		}

		output = output.substring(0, output.length() - 1);
		writeOutput(output);
	}

	public void getSlotNumberOfVehicle(String vehRegNum) {
		ParkingRequest req = parkingReqRepo.findByVehRegNum(vehRegNum).get(0);
		String output = "";
		output += req.getSlotNum();
		writeOutput(output);
	}

	public void getVehRegNumOfDriversAge(int age) {
		List<ParkingRequest> list = parkingReqRepo.findSlotNumByDriversAge(age);
		String output = "";
		for (ParkingRequest req : list) {
			output += req.getVehicleRegNum() + ",";
		}

		if (!output.isEmpty()) {
			output = output.substring(0, output.length() - 1);

		}

		writeOutput(output);
	}

}
