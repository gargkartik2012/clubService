package com.example.web.repository;

import com.example.web.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


// this jpa generate all the getter setter method
public interface  ClubRepository extends JpaRepository<Club,Long> {


    // these are custom query method it finds the property of club model and they create actual piece of code
    Optional<Club> findByTitle(String url);
}

