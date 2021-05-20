package com.example.projetfinal.Controller;

import com.example.projetfinal.DAO.EventRepository;
import com.example.projetfinal.DAO.ReservationRepository;
import com.example.projetfinal.DAO.TypeRepository;
import com.example.projetfinal.DAO.UserRepository;
import com.example.projetfinal.Entity.Event;
import com.example.projetfinal.Entity.Reservation;
import com.example.projetfinal.Entity.Type;
import com.example.projetfinal.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Home {

    private final UserRepository userRepository;
    private final ReservationRepository reservationRepository;
    private final EventRepository eventRepository;
    private final TypeRepository typeRepository;

    public Home(UserRepository userRepository, ReservationRepository reservationRepository, EventRepository eventRepository, TypeRepository typeRepository) {
        this.userRepository = userRepository;
        this.reservationRepository = reservationRepository;
        this.eventRepository = eventRepository;
        this.typeRepository = typeRepository;
    }

    @RequestMapping("/home")
    public String home(ModelMap model, HttpSession session) {
        if(session.getAttribute("user")==null){
            return "redirect:/login";
        }else
        {
        String userPseudo = (String) session.getAttribute("user");
        User user = userRepository.getUserByPseudo(userPseudo);
        model.addAttribute("user",user.getPseudo());

        List<Reservation> res = reservationRepository.getReservationsByUser(user);
            for(int i =0; i<res.size();i++){
                if(!res.get(i).isPayee()){
                    res.remove(i);
                }
            }
            model.addAttribute("res", res);
        return "home";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(value = "/deleteres/{resid}", method = RequestMethod.GET)
    public String DeleteReservation(@PathVariable("resid") Long resid) {
        reservationRepository.deleteById(resid);
        return "redirect:/home";
    }

    @RequestMapping(value = "/searchevent")
    public String serachevent(ModelMap model) {
        List<Type> typeAll = (List<Type>) typeRepository.findAll();
        model.addAttribute("type", typeAll);
        return "searchevent";
    }

    @RequestMapping(value = "/searchevent", method = RequestMethod.POST)
    public String serachevent(@RequestParam("title") String title, @RequestParam("date") String date, @RequestParam("loc") String loc, @RequestParam(value = "type", required=false) Type type, ModelMap model, HttpSession session) {

        List<Type> typeAll = (List<Type>) typeRepository.findAll();
        model.addAttribute("type", typeAll);

            List<Event> eve = null;
            if(type==null) {

                if (title.equals("")) {

                    if (loc.equals("")) {

                        if (date.equals("")) {model.addAttribute("error", "Please complete at least one field !");}

                        else {eve = eventRepository.getEventsByDate(date);}}

                    else{
                        if(date.equals("")){eve = eventRepository.getEventsByLocalisationIsContaining(loc);}

                        else{eve = eventRepository.getEventsByDateAndLocalisationIsContaining(date, loc);}

                    }
                }

                else {

                    if (loc.equals("")) {
                        if (date.equals("")){eve = eventRepository.getEventsByTitreIsContaining(title);}

                        else{eve = eventRepository.getEventsByDateAndTitreIsContaining(date, title);}
                }
                else
                {
                    if (date.equals("")) {eve = eventRepository.getEventsByTitreIsContainingAndLocalisationIsContaining(title, loc);}

                    else {eve = eventRepository.getEventsByTitreIsContainingAndDateAndLocalisationContaining(title, date, loc);}
                }
                }
            }
            else
            {
                if(title.equals("")){

                    if(loc.equals(""))
                    {
                        if(date.equals("")){eve = eventRepository.getEventsByType(type);}

                        else{eve = eventRepository.getEventsByDateAndType(date, type);}
                    }
                    else {
                        if (date.equals("")) {
                            eve = eventRepository.getEventsByLocalisationIsContainingAndType(loc, type);
                        } else {
                            eve = eventRepository.getEventsByDateAndTypeAndLocalisationIsContaining(date, type, loc);
                        }
                    }
                }
                else {
                    if(loc.equals("")){

                        if(date.equals("")){eve = eventRepository.getEventsByTitreIsContainingAndType(title, type);}

                        else{eve = eventRepository.getEventsByDateAndTypeAndTitreIsContaining(date, type, title); }
                    }
                    else{
                        if(date.equals("")){eve = eventRepository.getEventsByTitreIsContainingAndTypeAndLocalisationContaining(title, type,loc);}

                        else{eve = eventRepository.getEventsByDateAndTypeAndTitreIsContainingAndLocalisationIsContaining(date, type, title, loc);
                        }
                    }
                }
            }
        String userPseudo = (String) session.getAttribute("user");
        User user = userRepository.getUserByPseudo(userPseudo);

        List<Reservation> res = reservationRepository.getReservationsByUser(user);
        if(eve.size()!=0){
        for(int i=0;res.size()>i;i++){
            for(int j=0; eve.size()>j;j++){
                System.out.println(eve.get(j).getIdEvent() + " " + res.get(i).getEvent().getIdEvent());
                if(eve.get(j).getIdEvent().equals(res.get(i).getEvent().getIdEvent())){
                    eve.remove(j);
                }
            }
        }
            model.addAttribute("eve", eve);
        }
        return "searchevent";
    }

    @RequestMapping(value = "/panier")
    public String Panier(HttpSession session, ModelMap model) {
        String userPseudo = (String) session.getAttribute("user");
        User user = userRepository.getUserByPseudo(userPseudo);
        model.addAttribute("user",user.getPseudo());

        List<Reservation> res = reservationRepository.getReservationsByUser(user);
        for(int i =0; i<res.size();i++){
            if(res.get(i).isPayee()){
                res.remove(i);
            }
        }
        model.addAttribute("res", res);
        return "panier";
    }


    @RequestMapping(value = "/panier/validate")
    public String validateCheckout(HttpSession session, ModelMap model) {
        String userPseudo = (String) session.getAttribute("user");
        User user = userRepository.getUserByPseudo(userPseudo);
        model.addAttribute("user",user.getPseudo());

        List<Reservation> res = reservationRepository.getReservationsByUser(user);
            for(int i = 0; i<res.size();i++){
                res.get(i).setPayee(true);
                reservationRepository.save(res.get(i));
            }
        return "redirect:/home";
    }
}
