package com.squadstack.parkingapp.repo;

import org.springframework.data.repository.CrudRepository;

import com.squadstack.parkingapp.model.ParkingRecords;

public interface ParkingRecordsRepository extends CrudRepository<ParkingRecords, Long> {

}
