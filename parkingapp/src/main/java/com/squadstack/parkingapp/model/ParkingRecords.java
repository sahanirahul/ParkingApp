package com.squadstack.parkingapp.model;

import java.sql.Timestamp;

import org.springframework.data.annotation.Id;

public class ParkingRecords {

	@Id
	long slNum;
	long ticketId;
	int slotNum;
	String vehicleRegNum;
	int driversAge;
	Timestamp entryTimestamp;
	Timestamp exitTimestamp;

	@Override
	public String toString() {
		return " slNum : " + slNum + " | ticketId : " + ticketId + " | slotNum : " + slotNum + " | vehicleRegNum : " + vehicleRegNum
				+ " | driversAge : " + driversAge + " | entryTimestamp : " + entryTimestamp + " | exitTimestamp : "
				+ exitTimestamp;
	}

	public long getTicketId() {
		return ticketId;
	}

	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}

	public int getSlotNum() {
		return slotNum;
	}

	public void setSlotNum(int slotNum) {
		this.slotNum = slotNum;
	}

	public String getVehicleRegNum() {
		return vehicleRegNum;
	}

	public void setVehicleRegNum(String vehicleRegNum) {
		this.vehicleRegNum = vehicleRegNum;
	}

	public int getDriversAge() {
		return driversAge;
	}

	public void setDriversAge(int driversAge) {
		this.driversAge = driversAge;
	}

	public Timestamp getEntryTimeStamp() {
		return entryTimestamp;
	}

	public void setEntryTimeStamp(Timestamp entryTimeStamp) {
		this.entryTimestamp = entryTimeStamp;
	}

	public Timestamp getExitTimeStamp() {
		return exitTimestamp;
	}

	public void setExitTimeStamp(Timestamp exitTimeStamp) {
		this.exitTimestamp = exitTimeStamp;
	}
}
