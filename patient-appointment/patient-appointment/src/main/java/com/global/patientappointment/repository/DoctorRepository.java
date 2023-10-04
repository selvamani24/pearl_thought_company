package com.global.patientappointment.repository;

import com.global.patientappointment.model.Doctor;

import java.util.List;
@SuppressWarnings("unused")
public interface DoctorRepository {
    public List<Doctor> findAll();

    public Doctor findById(Long id);

    public void save(Doctor doctor);

}
