package com.example.U5W2D5WeeklyProject.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeDTO {
    @NotEmpty(message = "Name is required")
    @Size(min = 1, max = 40, message = "Characters must be between 1 and 40")
    String name;
    @NotEmpty(message = "Surname is required")
    @Size(min = 1, max = 40, message = "Characters must be between 1 and 40")
    String surname;

    @Email(message = "Email is required")
    String email;

    @NotEmpty(message = "Username is required")
    @Size(min = 1, max = 40, message = "Characters must be between 1 and 40")
    String username;

    
}
