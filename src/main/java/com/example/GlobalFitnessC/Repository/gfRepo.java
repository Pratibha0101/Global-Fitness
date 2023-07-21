package com.example.GlobalFitnessC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.GlobalFitnessC.Model.User;

public interface gfRepo extends JpaRepository<User, Integer> {
   
}
