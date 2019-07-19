package com.utt.controller;


import com.utt.dto.logindto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class login {
    @Autowired
    com.utt.loginservice.loginservice loginservice;


    @RequestMapping(value = "/login", method = RequestMethod.POST,headers = "Content-Type=multipart/form-data")
    public Optional result(@ModelAttribute logindto logindto) {
        return loginservice.dosomething(logindto);
    }

    @PostMapping("/getoneid")
    public Optional result2(@RequestParam("id") String id) {
        return loginservice.getone(id);
    }

    @PostMapping("/getall")
    public Iterable<logindto> result3() {
        return loginservice.getall();
    }

    @PostMapping("/getselected")
    public  List<logindto> result4(@RequestParam("text") String text)
    {
        return loginservice.elasticquery(text);

    }

    @PostMapping("/getselectednamephone")
    public  List<logindto> result4(@RequestParam("name") String name,@RequestParam("phone") String phone)
    {
        return loginservice.elasticqueryphonename(name,phone);

    }

}
