# ParkingApp
Java Application for providing parking ticket to vehicles in a hypothetical parking lot.

## Requirement
We own a vehicle parking lot with capacity "n" numbered 1,2,..,n with increasing distance from entry. We need to create a parking ticketing system which will generate parking ticket when a vehicle enters and vacate when it leaves.  
Along with these functions it should also give certain analytics about the vehicles parked and related informations.  
The ticketing system should read instructions from a input.txt file and write the outputs in a output.txt file.

## Functionalities required
### createParking(int size)
creates a parking lot of n = size  
input command = Create_parking_lot n

### generateParkingTicket(String veh_reg_num, int driversAge) 
generates a parking ticket for the vehicle with registration number = veh_reg_num and its driver's age = driversAge  
input command = Park veh_reg_num driver_age driversAge

### removeParkedVehicle(int slotNum)
vacates the parked vehicle at slot number = slotNum and the slot becomes available/vacant for new vehicle  
input command = Leave slotNum

### getSlotNumbersOfDriversAge(int age)
returns all the slots that are occupied with vehicles whose driver's age = age  
input command = Slot_numbers_for_driver_of_age age

### getSlotNumberOfVehicle(String vehRegNum)
returns the slot number at which a given vehicle with registration number = vehRegNum is parked  
input command = Slot_number_for_car_with_number vehRegNum

### getVehRegNumOfDriversAge(int age)
returns all the vehicle registraion number which are currently parked and the drivers's age =  age  
input command = Vehicle_registration_number_for_driver_of_age age

## Database Details and Data Schema
The required details to be stored for a parked vehicles = registration number, slot number, driver's age.  
Extra details that we will be storing = a ticketId and entry timestamp  
For this we will be using a sql database and a table named PARKING_REQUEST  
Also we will have another table to store vehicles that were parked and have left the parking lot in a table named PARKING_RECORDS

### The following columns will therefore be present in the table PARKING_REQUEST

TICKET_ID(Ticket id for the parking ticket,Auto Increment with 1)  
SLOT_NUM (parking slot where the vehicle is being parked)  
VEHICLE_REG_NUM (the registration number of the parked vehicle)  
DRIVERS_AGE (the age of the driver driving the parked vehicle)  
ENTRY_TIMESTAMP (the time at which the vehicle was parked)  

### The following columns will therefore be present in the table PARKING_RECORDS

SL_NUM (Serial number of records, auto increment with 1)  
TICKET_ID(Ticket id of the parking ticket )  
SLOT_NUM (parking slot where the vehicle is being parked)  
VEHICLE_REG_NUM (the registration number of the parked vehicle)  
DRIVERS_AGE (the age of the driver driving the parked vehicle)  
ENTRY_TIMESTAMP (the time at which the vehicle was parked)  
EXIT_TIMESTAMP (the time at which the parked vehicle wleft the parking)  

### Database used is a Microsoft Azure SQL database

Database used : Microsoft Azure Sql Database (free account) Database connection details:  
spring.datasource.url=****** spring.datasource.username=******* spring.datasource.password=********  
Because of Microsoft Firewall security a connection request from unknown IP will be declined, The IP should be added before to connect from application  
The Application connects to the database on start as such the database server should be up when running the application.  
The database configuration can be changed in the properties file.  

## Design Details

The application on start, will search for an input.txt file ( the file path has to be specified in the application.properties file) and it will start executing each command in the input file one by one.   
The output of this commands will be logged into the console and also will be written in an output.txt file (the file path to be specified in the application.properties file).  
Please look at the ApplicationDesignDiagram image for high level understanding of application flow.  

## How to build and run the application

The application code is written in java 8 and is a maven project.  
If an ide like eclipse is used you can directly run the application as java application (from the main class ParkingAppApplication).  
Else you can maven build using the cmd : "mvn clean install" and then run the jar using "java -jar jarName" (this will require jre 8)  
When directly running the jar please ensure that there is files/input.txt file in the same directory as the jar.
