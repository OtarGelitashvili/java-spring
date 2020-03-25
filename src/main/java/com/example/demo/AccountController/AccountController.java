package com.example.demo.AccountController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountController {

    @RequestMapping(value="/")
    public String home ()
    {
        return "index";
    }
}
