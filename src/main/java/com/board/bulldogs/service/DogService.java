package com.board.bulldogs.service;

import com.board.bulldogs.model.Dog;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DogService {
    private final List<Dog> dogs = new ArrayList<>();

    @PostConstruct
    public void init() {
        dogs.add(new Dog(1L, "Max", "Friendly English Bulldog", List.of(
                "/images/bulldog1.jpg",
                "/images/bulldog2.jpg",
                "/images/bulldog3.jpg"
        )));
        dogs.add(new Dog(2L, "Bella", "Playful French Bulldog", List.of(
                "/images/bulldog2.jpg",
                "/images/bulldog3.jpg",
                "/images/bulldog1.jpg"
        )));
    }

    public List<Dog> findAll() {
        return dogs;
    }

    public Optional<Dog> findById(Long id) {
        return dogs.stream().filter(d -> d.getId().equals(id)).findFirst();
    }
}
