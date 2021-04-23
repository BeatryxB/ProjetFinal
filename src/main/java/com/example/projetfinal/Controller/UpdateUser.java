package com.example.projetfinal.Controller;

import com.example.projetfinal.DAO.EventRepository;
import com.example.projetfinal.DAO.UserRepository;
import com.example.projetfinal.Entity.Event;
import com.example.projetfinal.Entity.Reservation;
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
            String userPseudo = (String) session.getAttribute("user");
            User user = userRepositorie.getUserByPseudo(userPseudo);
            model.addAttribute("user",user.getPseudo());


            if(user != null){
                model.addAttribute("user", user);
            }
            else
            {
                model.addAttribute("user", "They are not event");
            }

            return "updateuser";
        }
    }

    @RequestMapping(value = "/updateuser", method = RequestMethod.POST)
    public String loginRequest(@ModelAttribute("user") User user, BindingResult result, ModelMap model) {

        User u = (User) result.getTarget();
        System.out.println(u);

        if(u.getPseudo().equals("")||u.getPassword().equals(",")||u.getFirstName().equals("")||u.getLastName().equals("")||u.getDateOfBirth().equals("")||u.getGender().equals("")){
            model.addAttribute("error", "One of field isn't set");
        }
        else{
            String[] s= u.getPassword().split(",");
            if(s[0].equals(s[1])){
                u.setPassword(s[0]);
                try{
                    long l = userRepositorie.getUserByPseudo(u.getPseudo()).getIdUser();
                    model.addAttribute("error", "pseudo is already use");
                }catch (NullPointerException e)
                {

                    userRepositorie.save(u);
                    model.addAttribute("error", "Your account was update");
                }
            }
            else{
                model.addAttribute("error", "password didn't match");
            }

        }

        return "updateuser";
    }
}
