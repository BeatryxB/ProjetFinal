package com.example.projetfinal.DAO;

import com.example.projetfinal.Entity.Type;
import org.springframework.data.repository.CrudRepository;

public interface TypeRepository extends CrudRepository<Type, Long> {

    public Type getTypeByTypeFieldIsLike(String type);
}
