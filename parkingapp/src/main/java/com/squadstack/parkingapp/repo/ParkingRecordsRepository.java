package com.squadstack.parkingapp.repo;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.squadstack.parkingapp.model.ParkingRecords;
import com.squadstack.parkingapp.model.ParkingRequest;

public interface ParkingRecordsRepository extends CrudRepository<ParkingRecords, Long> {

	/*
	 * @Modifying
	 * 
	 * @Query("INSERT INTO PARKING_RECORDS VALUES(:ticketId,:slotNum,:vehRegNum,:driversAge,:entryTimestamp,:exitTimestamp)"
	 * )
	 * 
	 * @Transactional public void insert(@Param("ticketId") long
	 * ticketId,@Param("slotNum") int slotNum,@Param("vehRegNum") String
	 * vehRegNum,@Param("driversAge") int driversAge,@Param("entryTimestamp")
	 * Timestamp entryTimestamp,@Param("exitTimestamp") Timestamp exitTimestamp);
	 */
}
