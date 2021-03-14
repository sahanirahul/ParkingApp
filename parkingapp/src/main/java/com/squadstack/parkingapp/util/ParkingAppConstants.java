package com.squadstack.parkingapp.util;

import java.util.HashMap;

public class ParkingAppConstants {
	public static HashMap<String, Integer> commandMap = new HashMap<String, Integer>();
	
	public static void setCommands()
	{
		commandMap.put("Create_parking_lot", 1);
		commandMap.put("Park", 2);
		commandMap.put("Leave", 3);
		commandMap.put("Slot_numbers_for_driver_of_age", 4);
		commandMap.put("Slot_number_for_car_with_number", 5);
		commandMap.put("Vehicle_registration_number_for_driver_of_age", 6);
	}
}
