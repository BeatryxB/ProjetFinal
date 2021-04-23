package com.example.projetfinal.Controller;

import com.example.projetfinal.DAO.ReservationRepository;
import com.example.projetfinal.DAO.UserRepository;
import com.example.projetfinal.Entity.Reservation;
import com.example.projetfinal.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class Home {

    private UserRepository userRepository;
    private ReservationRepository reservationRepository;

    public Home(UserRepository userRepository, ReservationRepository reservationRepository) {
        this.userRepository = userRepository;
        this.reservationRepository = reservationRepository;
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
        if(res.size()>=0){
            model.addAttribute("res", res);
        }
        else{
            model.addAttribute("res", "This user doesn't have any reservation");
        }
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



}
