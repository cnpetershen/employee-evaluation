package com.peter.smartmedicalserver.mapper;

import com.peter.smartmedicalserver.entity.Doctor;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DoctorManageMapper {
    @Select("SELECT id, name ,position, department FROM doctors")
     List<Doctor> getAllDoctors();
    @Delete("delete from doctors where name = #{name}")
    void deleteDoctorByName(String name);
@Insert("INSERT INTO doctors(name, position, department) VALUES(#{name}, #{position}, #{department})")
    void addDoctor(Doctor doctor);
//    @Update("UPDATE doctors SET name = #{doctor.name}, position = #{doctor.position} WHERE name = #{doctor.name}")
//    void updateDoctor(@Param("doctor") Doctor doctor, @Param("position") String position);

    @Update("UPDATE doctors SET name = #{doctor.name},department=#{doctor.department}, position = #{doctor.position} WHERE name = #{name}")
    void updateDoctorbyName(String name, Doctor doctor);

    @Select("SELECT name,department,specialty FROM doctors")
    List<Doctor> getDoctors();
}
