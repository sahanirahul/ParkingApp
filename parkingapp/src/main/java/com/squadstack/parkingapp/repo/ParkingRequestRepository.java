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

	/*
	 * @Modifying
	 * 
	 * @Query("INSERT INTO HALL_BOOKING_REQUEST SET name = :name WHERE id = :id")
	 * boolean updateName(@Param("id") Long id, @Param("name") String name);
	 * 
	 * @Modifying
	 * 
	 * @Query("INSERT INTO HALL_BOOKING_REQUEST SET name = :name WHERE id = :id")
	 * boolean insertRequest(@Param("requestor_id") String
	 * requestor_id, @Param("requestor_name") String requestor_name);
	 */
	//SELECT * FROM HALL_BOOKING_REQUEST WHERE request_date = '2021-01-25' and start_time >= '09:00:00' and end_time <= '12:00:00'
	//@Query("SELECT * FROM PARKING WHERE request_date = :request_date and start_time >= :start_time and end_time <= :end_time")
	//List<HallBookingRequest> findBookedHall(@Param("request_date") Date request_date, @Param("start_time") Time start_time, @Param("end_time") Time end_time);
	@Query("SELECT * FROM PARKING_REQUEST WHERE SLOT_NUM = :slotNum")
	List<ParkingRequest> findBySlotNum(@Param("slotNum") int slotNum);
	
	@Query("SELECT * FROM PARKING_REQUEST WHERE vehicle_reg_num = :vehRegNum")
	List<ParkingRequest> findByVehRegNum(@Param("vehRegNum") String vehRegNum);
	
	@Query("DELETE FROM PARKING_REQUEST WHERE SLOT_NUM = :slotNum")
	void deleteBySlotNum(@Param("slotNum") int slotNum);
	
	@Query("SELECT * FROM PARKING_REQUEST WHERE DRIVERS_AGE = :driversAge")
	List<ParkingRequest> findSlotNumByDriversAge(@Param("driversAge") int driversAge);
}
