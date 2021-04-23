package com.example.projetfinal.Controller;

import com.example.projetfinal.DAO.EventRepository;
import com.example.projetfinal.DAO.UserRepository;
import com.example.projetfinal.Entity.Event;
import com.example.projetfinal.Entity.Reservation;
import com.example.projetfinal.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
public class Admin {

    private final EventRepository eventRepositorie;
    private final UserRepository userRepositorie;

    public Admin(EventRepository eventRepositorie, UserRepository userRepositorie) {
        this.eventRepositorie = eventRepositorie;
        this.userRepositorie = userRepositorie;
    }

    @GetMapping({"/admin"})
    public String admin(ModelMap model, HttpSession session)
    {
        if(session.getAttribute("user")==null){
            return "redirect:/login";
        }else
        {
            String userPseudo = (String) session.getAttribute("user");
            User user = userRepositorie.getUserByPseudo(userPseudo);
            model.addAttribute("user",user.getPseudo());

            List<Event> eventList = ((List<Event>) eventRepositorie.findAll());
            if(eventList.size()>=0){
                model.addAttribute("eventList", eventList);
            }
            else{
                model.addAttribute("eventList", "They are not event");
            }

            List<User> userList = ((List<User>) userRepositorie.findAll());
            if(userList.size()>=0){
                model.addAttribute("userList", userList);
            }
            else{
                model.addAttribute("userList", "0 user");
            }

            return "admin";
        }
    }

    @RequestMapping(value = "/deleteeven/{idEvent}", method = RequestMethod.GET)
    public String DeleteEvent(@PathVariable("idEvent") Long idEvent) {
        eventRepositorie.deleteById(idEvent);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/addEvent", method = RequestMethod.GET)
    public String AddEvent()
    {
        return "addEvent";
    }

    @RequestMapping(value = "/deleteuser/{idUser}", method = RequestMethod.GET)
    public String DeleteUser(@PathVariable("idUser") Long idUser) {
        userRepositorie.deleteById(idUser);
        return "redirect:/admin";
    }
}
