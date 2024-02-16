package com.example.U5W2D5WeeklyProject.entities;

import com.example.U5W2D5WeeklyProject.enums.DeviceStatus;
import com.example.U5W2D5WeeklyProject.enums.DeviceType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "devices")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Enumerated(EnumType.STRING)
    private DeviceType type;
    @Enumerated(EnumType.STRING)
    private DeviceStatus status;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


    public Device(DeviceType type, DeviceStatus status) {
        this.type = type;
        this.status = DeviceStatus.AVAILABLE;
    }
}
