package com.peter.smartmedicalserver.service;

import com.peter.smartmedicalserver.entity.Banner;
import com.peter.smartmedicalserver.mapper.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BannerService {
    @Autowired
private BannerMapper bannerMapper;
    public List<Banner> select() {
        return bannerMapper.select();
    }
}
