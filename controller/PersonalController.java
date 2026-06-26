package com.peter.smartmedicalserver.controller;

import com.peter.smartmedicalserver.entity.Personal;
import com.peter.smartmedicalserver.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personal")
public class PersonalController {
    @Autowired
    private PersonalService personalService;

    @PostMapping("/{username}")
    public Personal createPersonal(@RequestBody Personal personal,
                                   @PathVariable("username") String username) {
        personalService.insert(personal, username);
        return personal;
    }

    @GetMapping("/{username}")
    public Personal getPersonalByUsername(@PathVariable("username") String username) {
        Personal personal = personalService.findByUsername(username);
        return personal;
    }

    @PutMapping("/{username}")
    public Personal updatePersonal(@RequestBody Personal personal,
                                   @PathVariable("username") String username) {
        personalService.update(personal, username);
        return personal;
    }


}
