package com.example.projetfinal.Controller;

import com.example.projetfinal.DAO.EventRepository;
import com.example.projetfinal.DAO.UserRepository;
import com.example.projetfinal.Entity.Event;
import com.example.projetfinal.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class AUEvent {

    private final UserRepository userRepositorie;
    private final EventRepository eventRepositorie;

    public AUEvent(UserRepository userRepositorie, EventRepository eventRepository) {
        this.userRepositorie = userRepositorie;
        this.eventRepositorie = eventRepository;

    }

    @RequestMapping("/auEvent")
    public String signup(HttpSession session) {
        if(session.getAttribute("user")==null){
            return "redirect:/home";
        }
        else{
            return "auEvent";
        }
    }





    @RequestMapping(value = "/auEvent", method = RequestMethod.POST)
    public String AddEventRequest(@ModelAttribute("event") Event event, BindingResult result, ModelMap model) {

        Event u = (Event) result.getTarget();
        System.out.println(u);

        if(u.getTitre().equals("")||u.getDescription().equals("")||u.getLocalisation().equals("")||u.getDate().equals("")||u.getType().equals("")||u.getType().equals("")){
            model.addAttribute("error", "One of field isn't set");
        }
        else{

            eventRepositorie.save(u);
            model.addAttribute("error", "Your event was created, please sign in please");

        }

        return "auEvent";
    }



}
