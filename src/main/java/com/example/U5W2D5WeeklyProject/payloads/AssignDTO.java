package com.example.U5W2D5WeeklyProject.payloads;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class AssignDTO {
    @NotEmpty(message = "Employee email is required")
    String email;
}
