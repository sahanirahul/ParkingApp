package com.squadstack.parkingapp.repo;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.squadstack.parkingapp.model.ParkingRequest;
@Repository
public interface ParkingRequestRepository extends CrudRepository<ParkingRequest, Long> {
	@Query("SELECT * FROM PARKING_REQUEST WHERE SLOT_NUM = :slotNum")
	List<ParkingRequest> findBySlotNum(@Param("slotNum") int slotNum);
	
	@Query("SELECT * FROM PARKING_REQUEST WHERE vehicle_reg_num = :vehRegNum")
	List<ParkingRequest> findByVehRegNum(@Param("vehRegNum") String vehRegNum);
	
	@Query("DELETE FROM PARKING_REQUEST WHERE SLOT_NUM = :slotNum")
	void deleteBySlotNum(@Param("slotNum") int slotNum);
	
	@Query("SELECT * FROM PARKING_REQUEST WHERE DRIVERS_AGE = :driversAge")
	List<ParkingRequest> findSlotNumByDriversAge(@Param("driversAge") int driversAge);
}
