package com.global.patientappointment.controlller;

import com.global.patientappointment.model.Appointment;
import com.global.patientappointment.model.Doctor;
import com.global.patientappointment.repository.AppointmentRepository;
import com.global.patientappointment.repository.DoctorRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@RestController
@RequestMapping("/appointments/")
@SuppressWarnings("all")
public class AppointmentController {
    @Autowired
    private final AppointmentRepository appointmentRepository;
    @Autowired
    private final DoctorRepository doctorRepository;

    @GetMapping("/available")
    public List<Object> getAvailableAppointments(@RequestParam Long doctorId, @RequestParam String dateTime) {
        Doctor doctor = doctorRepository.findById(doctorId);
        if (doctor == null) {
            return Collections.singletonList(new ArrayList<Object>().add("Doctor not available"));
        }

        LocalDateTime requestedDateTime = LocalDateTime.parse(dateTime);
        return Collections.singletonList(appointmentRepository.findByDoctorAndAvailableTrueAndDateTimeAfter(doctor, requestedDateTime));
    }

    @PostMapping("/book")
    public void bookAppointment(@RequestParam Long appointmentId) throws IllegalAccessException {
        Appointment appointment = appointmentRepository.findById(appointmentId);
        if (appointment == null || !appointment.isAvailable()) {
            throw new IllegalAccessException("give a valid input");
        }

        appointment.setAvailable(false);
    }

}
