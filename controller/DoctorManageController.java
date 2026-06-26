package com.peter.smartmedicalserver.controller;

import com.peter.smartmedicalserver.entity.Doctor;
import com.peter.smartmedicalserver.service.DoctorManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorManageController {
    @Autowired
    private DoctorManageService doctorManageService;

    @GetMapping("/admin/role/personnel")
    public List<Doctor> getAllDoctors() {
        return doctorManageService.getAllDoctors();
    }
    @PostMapping("/admin/role/personnel")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        doctorManageService.addDoctor(doctor);
        return doctor;
    }

    @DeleteMapping("/admin/role/personnel/{name}")
    public void deleteDoctor(@PathVariable("name") String name) {
        doctorManageService.deleteDoctorByName(name);
    }
    @PutMapping("/admin/role/personnel/{name}")
    public void updateUser( @RequestBody Doctor doctor,@PathVariable String name) {
        doctorManageService.updateDoctorbyName(name,doctor);
    }

    @GetMapping("/choice/index")
    public List<Doctor> getDoctors() {
        return doctorManageService.getDoctors();
    }
}
