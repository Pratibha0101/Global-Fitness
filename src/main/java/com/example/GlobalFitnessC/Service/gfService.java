package com.example.GlobalFitnessC.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GlobalFitnessC.Model.User;
import com.example.GlobalFitnessC.Repository.gfRepo;

@Service
public class gfService {
    
    @Autowired
    gfRepo gf;

    public void add(User use) {
        gf.save(use);
    }

    public List<User> getAll() {
        return gf.findAll();
    }

     public List<User> getByEmail(String email) {
        return gf.findAll();
    }

    

}
