package com.example.U5W2D5WeeklyProject.exceptions;

import java.util.UUID;

public class UUIDNotFoundException extends RuntimeException {
    public UUIDNotFoundException(UUID id) {
        super("Employee with  " + id + " was not found");
    }
}