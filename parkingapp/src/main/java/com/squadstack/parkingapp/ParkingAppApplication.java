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
		Environment env = ApplicationContextLoader.getAppContext().getEnvironment();
		
		String inputFile = env.getProperty("inputFile");
		String outputFile = env.getProperty("outputFile");
		ApplicationContextLoader.getAppContext().getBean(ParkingService.class).startParkingService(inputFile,outputFile);
	}

}
