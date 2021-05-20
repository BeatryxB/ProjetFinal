package com.example.projetfinal.Controller;

import com.example.projetfinal.DAO.EventRepository;
import com.example.projetfinal.DAO.UserRepository;
import com.example.projetfinal.Entity.Event;
import com.example.projetfinal.Entity.Reservation;
import com.example.projetfinal.Entity.Type;
import com.example.projetfinal.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
public class UpdateUser {

    private final UserRepository userRepositorie;

    public UpdateUser(UserRepository userRepositorie) {
        this.userRepositorie = userRepositorie;
    }

    @GetMapping({"/updateuser"})
    public String admin(ModelMap model, HttpSession session)
    {
        if(session.getAttribute("user")==null){
            return "redirect:/login";
        }
        else
        {
            return "redirect:/admin";
        }
    }
}
