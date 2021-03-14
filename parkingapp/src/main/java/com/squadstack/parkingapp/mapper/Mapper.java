package com.squadstack.parkingapp.mapper;

import com.squadstack.parkingapp.model.ParkingRecords;
import com.squadstack.parkingapp.model.ParkingRequest;

public class Mapper {

	public static ParkingRecords mapParkingRequestsToParkingRecords(ParkingRequest req)
	{
		ParkingRecords record = new ParkingRecords();
		record.setDriversAge(req.getDriversAge());
		record.setEntryTimeStamp(req.getEntryTimeStamp());
		record.setSlotNum(req.getSlotNum());
		record.setVehicleRegNum(req.getVehicleRegNum());
		record.setTicketId(req.getTicketId());
		return record;
	}
}
