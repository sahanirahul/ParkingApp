package com.squadstack.parkingapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import com.squadstack.parkingapp.service.ParkingService;
import com.squadstack.parkingapp.util.*;

@SpringBootApplication
public class ParkingAppApplication {
	
	
	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run(ParkingAppApplication.class, args);
		ApplicationContextLoader.setAppContext(appContext);
		startApp();
	}
	
	public static void startApp()
	{
		Properties prop =  new Properties();
		File propFile = new File("src/main/resources/application.properties");
	    InputStream inStream;
		try {
			inStream = new FileInputStream(propFile);
			prop.load(inStream);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		String inputFile = prop.getProperty("inputFile");
		String outputFile = prop.getProperty("outputFile");
		ApplicationContextLoader.getAppContext().getBean(ParkingService.class).startParkingService(inputFile,outputFile);
	}

}
