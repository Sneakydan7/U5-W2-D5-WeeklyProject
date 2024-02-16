package com.example.U5W2D5WeeklyProject.repositories;

import com.example.U5W2D5WeeklyProject.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceDAO extends JpaRepository<Device, Long> {

}
