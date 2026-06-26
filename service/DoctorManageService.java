package com.peter.smartmedicalserver.service;

import com.peter.smartmedicalserver.entity.Doctor;
import com.peter.smartmedicalserver.entity.User;
import com.peter.smartmedicalserver.mapper.DoctorManageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class DoctorManageService {
    @Autowired
    private DoctorManageMapper doctorManageMapper;

    public List<Doctor> getAllDoctors() {
        return doctorManageMapper.getAllDoctors();
    }
    public void addDoctor(@RequestBody Doctor doctor) {
        doctorManageMapper.addDoctor(doctor);
    }


    public void deleteDoctorByName(String name) {
        doctorManageMapper.deleteDoctorByName(name);
    }


//    public void updateDoctor(Doctor doctor, String position) {
//        doctorManageMapper.updateDoctor(doctor, position);
//    }

    public void updateDoctorbyName(String name, Doctor doctor) {
        doctorManageMapper.updateDoctorbyName(name, doctor);
    }

    public List<Doctor> getDoctors() {
        return doctorManageMapper.getDoctors();
    }
}
