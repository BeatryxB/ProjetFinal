package com.example.projetfinal.Controller;

import com.example.projetfinal.DAO.UserRepository;
import com.example.projetfinal.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignUp {
    private final UserRepository repositorie;

    public SignUp(UserRepository repositorie) {
        this.repositorie = repositorie;
    }

    @RequestMapping("/signup")
    public String signup() {
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
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
                        long l = repositorie.getUserByPseudo(u.getPseudo()).getIdUser();
                        model.addAttribute("error", "pseudo is already use");
                    }catch (NullPointerException e)
                    {

                        repositorie.save(u);
                        model.addAttribute("error", "Your account was created, please sign in please");
                    }
            }
            else{
                model.addAttribute("error", "password didn't match");
            }

        }

        return "signup";
    }

}
