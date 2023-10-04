package com.global.patientappointment.controlller;

import com.global.patientappointment.model.Doctor;
import com.global.patientappointment.repository.DoctorRepository;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorRepository doctorRepository;

    @PostMapping("/addDoctor")
    public void addDoctor(@RequestBody Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctorRepository.findById(id);
    }
}
