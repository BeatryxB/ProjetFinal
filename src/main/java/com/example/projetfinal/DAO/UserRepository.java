package com.example.projetfinal.DAO;

import com.example.projetfinal.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    public User getUserByPseudo(String Pseudo);
    public User getUserByIdUser(int idUser);

}
