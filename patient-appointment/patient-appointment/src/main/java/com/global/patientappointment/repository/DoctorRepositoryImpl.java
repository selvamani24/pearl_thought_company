package com.global.patientappointment.repository;

import com.global.patientappointment.model.Doctor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
@SuppressWarnings("unused")
public class DoctorRepositoryImpl implements DoctorRepository{
    private static final Map<Long, Doctor> DOCTOR_MAP = new HashMap<>();

    public List<Doctor> findAll() {
        return new ArrayList<>(DOCTOR_MAP.values());
    }

    public Doctor findById(Long id) {
        return DOCTOR_MAP.get(id);
    }

    public void save(Doctor doctor) {
        DOCTOR_MAP.put(doctor.getId(), doctor);
    }
}
