package com.example.projetfinal.DAO;

import com.example.projetfinal.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
