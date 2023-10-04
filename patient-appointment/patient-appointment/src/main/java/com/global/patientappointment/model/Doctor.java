package com.global.patientappointment.model;

import lombok.Data;

import java.util.List;

@Data
public class Doctor {
    private Long id;
    private String name;
    private String specialty;
    private int maxAppointments;
    private List<Appointment> appointments;

}
