package com.peter.smartmedicalserver.service;

import com.peter.smartmedicalserver.entity.ChoiceDetail;
import com.peter.smartmedicalserver.mapper.ChoiceDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChoiceDetailService {
    @Autowired
    private ChoiceDetailMapper choicedetailMapper;

    public ChoiceDetail getDetailById(int id) {
        return choicedetailMapper.getDetailById(id);
    }
}
