# ParkingApp
Java Application for providing parking ticket to vehicles in a hypothetical parking lot.

## Requirement
We own a vehicle parking lot with capacity "n" numbered 1,2,..,n with increasing distance from entry. We need to create a parking ticketing system which will generate parking ticket when a vehicle enters and vacate when it leaves. Along with these functions it should also give certain analytics about the vehicles parked and related informations.
The ticketing system should read instructions from a input.txt file and write the outputs in a output.txt file.

## Functionalities required
### createParking(int size)
creates a parking lot of n = size
### generateParkingTicket(String veh_reg_num, int driversAge) 
generates a parking ticket for the vehicle with registration number = veh_reg_num and its driver's age = driversAge
### removeParkedVehicle(int slotNum)
vacates the parked vehicle at slot number = slotNum and the slot becomes available/vacant for new vehicle
### getSlotNumbersOfDriversAge(int age)
returns all the slots that are occupied with vehicles whose driver's age = age
### getSlotNumberOfVehicle(String vehRegNum)
returns the slot number at which a given vehicle with registration number = vehRegNum is parked
### getVehRegNumOfDriversAge(int age)
returns all the vehicle registraion number which are currently parked and the drivers's age =  age
