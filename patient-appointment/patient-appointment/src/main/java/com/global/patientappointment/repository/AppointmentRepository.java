package com.global.patientappointment.repository;

import com.global.patientappointment.model.Appointment;
import com.global.patientappointment.model.Doctor;

import java.time.LocalDateTime;
import java.util.List;

@SuppressWarnings("unused")
public interface AppointmentRepository {
    public List<Appointment> findByDoctorAndAvailableTrueAndDateTimeAfter(Doctor doctor, LocalDateTime dateTime);
    public Appointment findById(Long id);
    public void save(Appointment appointment);

}
