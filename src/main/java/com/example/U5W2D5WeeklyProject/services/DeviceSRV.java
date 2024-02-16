package com.example.U5W2D5WeeklyProject.services;

import com.example.U5W2D5WeeklyProject.entities.Device;
import com.example.U5W2D5WeeklyProject.entities.Employee;
import com.example.U5W2D5WeeklyProject.exceptions.NotFoundException;
import com.example.U5W2D5WeeklyProject.payloads.DeviceDTO;
import com.example.U5W2D5WeeklyProject.payloads.EmployeeDTO;
import com.example.U5W2D5WeeklyProject.repositories.DeviceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeviceSRV {
    @Autowired
    private DeviceDAO deviceDAO;

    public Page<Device> getDevices(int pageNum, int size, String orderBy) {
        if (size > 100) size = 100;
        Pageable pageable = PageRequest.of(pageNum, size, Sort.by(orderBy));
        return deviceDAO.findAll(pageable);
    }


    public Device getDeviceById(Long id) {
        return deviceDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Device saveDevice(DeviceDTO newDevice) {
        return deviceDAO.save(new Device(newDevice.getDeviceType()));
    }

    public Device updateDeviceById(Device updatedDevice, Long id) {
        Device found = getDeviceById(id);
        found.setStatus(updatedDevice.getStatus());
        found.setEmployee(updatedDevice.getEmployee());
        found.setType(updatedDevice.getType());
        found.setEmployee(updatedDevice.getEmployee());
        return found;
    }

    public void deleteDevice(Long id) {
        Device found = getDeviceById(id);
        deviceDAO.delete(found);
    }

}
