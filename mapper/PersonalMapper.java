package com.peter.smartmedicalserver.mapper;

import com.peter.smartmedicalserver.entity.Personal;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface PersonalMapper {
    @Insert("INSERT INTO personal (name, idCard, phone, birthDate, country, ethnicity, address, Photo,username) " +
            "VALUES (#{name}, #{idCard}, #{phone}, #{birthDate}, #{country}, #{ethnicity}, #{address}, #{Photo},#{username})")
    int insert(Personal personal);

    @Select("SELECT * FROM personal WHERE username = #{username}")
    Personal findByUsername(String username);

    @Update("UPDATE personal SET name = #{name}, phone = #{phone}, idCard = #{idCard}, birthDate = #{birthDate}," +
            "country=#{country}, ethnicity=#{ethnicity}, " +
            "address = #{address} WHERE username = #{username}")
    void update(Personal personal);
}
