package com.example.projetfinal.Controller;

import com.example.projetfinal.DAO.ReservationRepository;
import com.example.projetfinal.DAO.UserRepository;
import com.example.projetfinal.Entity.Reservation;
import com.example.projetfinal.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Home {

    private UserRepository userRepository;
    private ReservationRepository reservationRepository;

    public Home(UserRepository userRepository, ReservationRepository reservationRepository) {
        this.userRepository = userRepository;
        this.reservationRepository = reservationRepository;
    }

    @RequestMapping("/home")
    public String home(@ModelAttribute("user") User user, ModelMap model) {
        model.addAttribute("user",user.getPseudo());

        if(reservationRepository.getReservationByUser(user).getIdEvent()!=null){
            model.addAttribute("res","this user don't have any Reservation");
        }

        return "home";
    }


}
