package com.example.projetfinal.Controller;

import com.example.projetfinal.DAO.EventRepository;
import com.example.projetfinal.DAO.TypeRepository;
import com.example.projetfinal.DAO.UserRepository;
import com.example.projetfinal.Entity.Event;
import com.example.projetfinal.Entity.Type;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AUEvent {

    private final EventRepository eventRepositorie;
    private final TypeRepository typeRepository;

    public AUEvent(UserRepository userRepositorie, EventRepository eventRepository, TypeRepository typeRepository) {
        this.eventRepositorie = eventRepository;
        this.typeRepository = typeRepository;
    }

    @RequestMapping("/event")
    public String auEvent(HttpSession session, ModelMap model) {
        if(session.getAttribute("user")==null){
            return "redirect:/login";
        }
        else{
            List<Type> typeAll = (List<Type>) typeRepository.findAll();
            model.addAttribute("type", typeAll);
            model.addAttribute("button", "Add one event");
            model.addAttribute("action","/addevent");
            return "auEvent";
        }
    }

    @RequestMapping(value = "/addevent", method = RequestMethod.POST)
    public String AddEventRequest(@ModelAttribute("event") Event event, BindingResult result, ModelMap model, @RequestParam("typeadd") String addType) {


        Event eve = (Event) result.getTarget();
        System.out.println(eve);

        if(eve.getTitre().equals("")||eve.getDescription().equals("")||eve.getLocalisation().equals("")||eve.getDate().equals("")||eve.getTime().equals("")|| eve.getType() == null){
            if(addType.equals("")){
                model.addAttribute("error", "One of field isn't set");
                List<Type> typeAll = (List<Type>) typeRepository.findAll();
                model.addAttribute("type", typeAll);
                model.addAttribute("button","add one event");
                model.addAttribute("action","/addevent");
            }else
            {
                Type t = new Type(addType);
                typeRepository.save(t);
                eve.setType(typeRepository.getTypeByTypeFieldIsLike(t.getTypeField()));
                eventRepositorie.save(eve);
                return "redirect:/admin";
            }
        }
        else{
            eventRepositorie.save(eve);
            return "redirect:/admin";
        }
        return "auEvent";
    }

    @RequestMapping(value = "/auEvent", method = RequestMethod.POST)
    public String UpdateEventRequest(@ModelAttribute("event") Event event, BindingResult result, ModelMap model) {

        Event u = (Event) result.getTarget();
        System.out.println(u);

        if(u.getTitre().equals("")||u.getDescription().equals("")||u.getLocalisation().equals("")||u.getDate().equals("")||u.getType().equals("")||u.getType().equals("")){
            model.addAttribute("error", "One of field isn't set");
        }
        else{
            eventRepositorie.save(u);
            return "redirect:/admin";

        }

        return "auEvent";
    }

}
