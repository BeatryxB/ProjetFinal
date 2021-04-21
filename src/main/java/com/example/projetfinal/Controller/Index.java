package com.example.projetfinal.Controller;

import com.example.projetfinal.DAO.UserRepository;
import com.example.projetfinal.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Index {

    private final UserRepository repositorie;

    public Index(UserRepository repositorie) {
        this.repositorie = repositorie;
    }

    @GetMapping({"/","/hello"})
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }


}
