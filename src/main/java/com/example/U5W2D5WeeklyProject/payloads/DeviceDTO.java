package com.example.U5W2D5WeeklyProject.payloads;

import com.example.U5W2D5WeeklyProject.enums.DeviceStatus;
import com.example.U5W2D5WeeklyProject.enums.DeviceType;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DeviceDTO {
    @NotEmpty(message = "A device type is required") DeviceType deviceType;
    DeviceStatus deviceStatus;
}
