package com.example.projetfinal.Entity;

import com.example.projetfinal.DAO.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserLoader implements CommandLineRunner {
    private final UserRepository repository;

    @Autowired
    public UserLoader(UserRepository repository){
        this.repository = repository;
    }
    @Override
    public void run(String... strings)throws Exception {
        this.repository.save(new User("beatryx", "Beugnet", "17/08/1997", false, "Female"));
    }
}
