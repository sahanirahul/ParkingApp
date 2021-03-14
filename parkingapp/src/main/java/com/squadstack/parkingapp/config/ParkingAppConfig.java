package com.squadstack.parkingapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.squadstack.parkingapp.util.*;;

@Configuration
public class ParkingAppConfig {

	@Bean
	public void setCommandMap()
	{
		ParkingAppConstants.setCommands();
	}
}
