package com.example.U5W2D5WeeklyProject.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Long id) {
        super("Device with  " + id + " was not found");
    }
}
