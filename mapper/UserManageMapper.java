package com.peter.smartmedicalserver.mapper;

import com.peter.smartmedicalserver.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserManageMapper {
    @Select("select * from user")
     List<User> getAllUser();

    @Insert("insert into user (username,password) values (#{username},#{password})")
    void addUser(User user);
    @Delete("delete from user where username = #{username}")
    void deleteUserByUsername(String username);
    @Update("UPDATE user SET username = #{user.username}, password = #{user.password} WHERE username = #{oldUsername}")
    void updateUser(@Param("user") User user, @Param("oldUsername") String oldUsername);

}
