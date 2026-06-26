package com.peter.smartmedicalserver.mapper;

import com.peter.smartmedicalserver.entity.ChoiceDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface ChoiceDetailMapper {
    @Select("SELECT * FROM choice_detail WHERE id = #{id}")
    ChoiceDetail getDetailById(@Param("id") int id);
}
