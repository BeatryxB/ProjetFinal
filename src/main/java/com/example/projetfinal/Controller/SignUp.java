package com.example.projetfinal.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class SignUp {

    @RequestMapping("/signup")
    public String signup() {
        return "signup";
    }
}
