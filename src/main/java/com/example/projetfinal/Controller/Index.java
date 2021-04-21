package com.example.projetfinal.Controller;

import com.example.projetfinal.DAO.UserRepository;
import com.example.projetfinal.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Index {

    private final UserRepository repositorie;

    public Index(UserRepository repositorie) {
        this.repositorie = repositorie;
    }

    @GetMapping({"/","/hello"})
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="Beatryx") String name) {
        model.addAttribute("name", name);
        User u = this.repositorie.getUserByPseudo("voilumets");
        model.addAttribute("username1", u.getFirstName());
        this.repositorie.save(new User("violent","jean", "Dupont", "17/08/1998", false, "Male","co"));
        model.addAttribute("username2", this.repositorie.findById(2L).get().getPseudo());
        model.containsAttribute("error");
        return "hello";
    }


}
