package com.example.projetfinal.Controller;

import com.example.projetfinal.DAO.*;
import com.example.projetfinal.Entity.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Controller
public class Admin {

    private final EventRepository eventRepositorie;
    private final UserRepository userRepositorie;
    private final TypeRepository typeRepository;
    private final ReservationRepository reservationRepository;
    private final ReservationDateRepository reservationDateRepository;

    public Admin(EventRepository eventRepositorie, UserRepository userRepositorie, TypeRepository typeRepository, ReservationRepository reservationRepository, ReservationDateRepository reservationDateRepository) {
        this.eventRepositorie = eventRepositorie;
        this.userRepositorie = userRepositorie;
        this.typeRepository = typeRepository;
        this.reservationRepository = reservationRepository;
        this.reservationDateRepository = reservationDateRepository;
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

    @RequestMapping(value = "/event/edit/{idEvent}", method = RequestMethod.GET)
    public String editEvent(@PathVariable("idEvent") Long idEvent,ModelMap model) {

        Event eve = eventRepositorie.getEventByIdEvent((long) Math.toIntExact(idEvent));
        List<Type> typeAll = (List<Type>) typeRepository.findAll();

        model.addAttribute("titre",eve.getTitre());
        model.addAttribute("description",eve.getDescription());
        model.addAttribute("date",eve.getDate());
        model.addAttribute("time",eve.getTime());
        model.addAttribute("type",typeAll);
        model.addAttribute("selected",eve.getType());
        model.addAttribute("localisation", eve.getLocalisation());
        model.addAttribute("button", "Update");
        model.addAttribute("action", "/event/update/"+eve.getIdEvent());

        return "auEvent";
    }

    @RequestMapping(value = "/event/update/{idEvent}", method = RequestMethod.POST)
    public String updateEvent(@PathVariable("idEvent") Long idEvent, @ModelAttribute("event") Event event, BindingResult result, ModelMap model, @RequestParam("typeadd") String addType) {

        Event eve = (Event) result.getTarget();

        if(eve.getTitre().equals("")||eve.getDescription().equals("")||eve.getLocalisation().equals("")||eve.getDate().equals("")||eve.getTime().equals("")|| eve.getType() == null){
            if(addType.equals("")){
                model.addAttribute("error", "One of field isn't set");
                List<Type> typeAll = (List<Type>) typeRepository.findAll();
                model.addAttribute("titre",eve.getTitre());
                model.addAttribute("description",eve.getDescription());
                model.addAttribute("date",eve.getDate());
                model.addAttribute("time",eve.getTime());
                model.addAttribute("type",typeAll);
                model.addAttribute("selected",eve.getType());
                model.addAttribute("localisation", eve.getLocalisation());
                model.addAttribute("button", "Update");
                model.addAttribute("action", "/event/update/"+eve.getIdEvent());
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

    @RequestMapping(value = "/deleteuser/{idUser}", method = RequestMethod.GET)
    public String DeleteUser(@PathVariable("idUser") Long idUser) {
        userRepositorie.deleteById(idUser);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/user/edit/{idUser}", method = RequestMethod.GET)
    public String loginRequest(@PathVariable("idUser") Long idUser, ModelMap model) {

        User user = userRepositorie.getUserByIdUser((long) Math.toIntExact(idUser));
        model.addAttribute("pseudo",user.getPseudo());
        model.addAttribute("firstName",user.getFirstName());
        model.addAttribute("lastName",user.getLastName());
        model.addAttribute("dateOfBirth",user.getDateOfBirth());
        model.addAttribute("gender",user.getGender());
        model.addAttribute("password",user.getPassword());
        return "updateuser";
    }

    @RequestMapping(value = "/addreservation/{idEvent}", method = RequestMethod.GET)
    public String addReservation(@PathVariable("idEvent") Long idEvent, HttpSession session) {
        String userPseudo = (String) session.getAttribute("user");
        User user = userRepositorie.getUserByPseudo(userPseudo);
        Event event = eventRepositorie.getEventByIdEvent(idEvent);
        reservationRepository.save(new Reservation(user,event));
        //Reservation res = reservationRepository.getReservationByUserAndEvent(user,event);
        //reservationDateRepository.save(new ReservationDate(res,java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
        return "redirect:/home";
    }
}
