package com.squadstack.parkingapp.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class ParkingAppUtil {

	public static BufferedReader getBufferedReader(String filename)
	{
		try {
			FileInputStream inputStream = null;
			File inputFile = new File(filename);

			inputStream = new FileInputStream(inputFile);
			return new BufferedReader(new InputStreamReader(inputStream));
		}
		catch(Exception e)
		{
			
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static BufferedWriter getBufferedWriter(String filename)
	{
		try {			
			File outputFile = new File(filename);
			FileWriter writer = new FileWriter(outputFile);  
		    return new BufferedWriter(writer); 		}
		catch(Exception e)
		{
			
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
		
	}
}
