package com.example.projetfinal.Controller;

import com.example.projetfinal.DAO.UserRepository;
import com.example.projetfinal.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class Index {

    private final UserRepository repositorie;

    public Index(UserRepository repositorie) {
        this.repositorie = repositorie;
    }

    @GetMapping({"/"})
    public String hello(HttpSession session) {
        if(session.getAttribute("user")!=null){
            return "redirect:/home";
        }
        else{
            return "hello";
        }
    }


}
