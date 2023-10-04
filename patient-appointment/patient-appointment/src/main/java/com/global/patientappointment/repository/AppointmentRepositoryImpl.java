package com.global.patientappointment.repository;

import com.global.patientappointment.model.Appointment;
import com.global.patientappointment.model.Doctor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Repository
@SuppressWarnings("unused")
public class AppointmentRepositoryImpl implements AppointmentRepository {

    private static final Map<Long, Appointment> APPOINTMENT_HASH_MAP = new HashMap<>();
    private static Long idCounter = 1L;

    public List<Appointment> findByDoctorAndAvailableTrueAndDateTimeAfter(Doctor doctor, LocalDateTime dateTime) {
        return APPOINTMENT_HASH_MAP.values().stream()
                .filter(appointment -> appointment.isAvailable() &&
                        appointment.getDateTime().isAfter(dateTime) &&
                        appointment.getDoctor().equals(doctor))
                .collect(Collectors.toList());
    }

    public Appointment findById(Long id) {
        return APPOINTMENT_HASH_MAP.get(id);
    }

    public void save(Appointment appointment) {
        if (appointment.getId() == null) {
            appointment.setId(idCounter++);
        }
        APPOINTMENT_HASH_MAP.put(appointment.getId(), appointment);
    }

}
