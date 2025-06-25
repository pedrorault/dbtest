package com.example.oracledb;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class EntityService {

    @Transactional
    public MyEntity save(MyEntity entity){
        entity.persist();
        return entity;
    }
}
