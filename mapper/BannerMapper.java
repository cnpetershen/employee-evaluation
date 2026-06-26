package com.peter.smartmedicalserver.mapper;

import com.peter.smartmedicalserver.entity.Banner;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface BannerMapper {
    @Select("select * from banner")
    List<Banner> select();
}
