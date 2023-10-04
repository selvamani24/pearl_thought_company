package com.global.patientappointment.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Appointment {
    private Long id;
    private LocalDateTime dateTime;
    private boolean available;
    private Doctor doctor;

}
