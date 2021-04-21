package com.example.projetfinal.Controller;

import com.example.projetfinal.DAO.UserRepository;
import com.example.projetfinal.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Controller
@WebServlet("/login")
public class Login {

    private UserRepository repository;

    public Login(UserRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginRequest(@ModelAttribute("user") User user, BindingResult result, ModelMap model) {

        User u = (User) result.getTarget();

        if(u.getPseudo().equals("")||u.getPassword().equals("")){
            model.addAttribute("error", "One of field isn't set");
        }
        else{

            try{
                long l = repository.getUserByPseudo(u.getPseudo()).getIdUser();
                if(repository.findById(l).get().getPassword().equals(u.getPassword())){
                    return "home";
                }
                else{
                    model.addAttribute("error", "username or password doesn't match");
                }
            }catch (NullPointerException e)
            {
                model.addAttribute("error", "username or password doesn't match");
            }

        }

        return "login";
    }

    @RequestMapping("/home")
    public String loginokay() {
        return "home";
    }
}
