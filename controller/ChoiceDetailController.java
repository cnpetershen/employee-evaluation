package com.peter.smartmedicalserver.controller;

import com.peter.smartmedicalserver.entity.ChoiceDetail;
import com.peter.smartmedicalserver.service.ChoiceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/choice")
public class ChoiceDetailController {
    @Autowired
    private ChoiceDetailService choicedetailService;
    @GetMapping("/detail/{doctorId}")
    public ChoiceDetail getDetailById(@PathVariable("doctorId") int id){
        return choicedetailService.getDetailById(id);
    }
}
