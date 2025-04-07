package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {

    private Map<Integer, Animal> animals=new HashMap<>();

    @Value("${course.name}")
    private String courseName;

    @Value("${project.developer.fullname}")
    private String developerName;

    @GetMapping
    public List<Animal> getAllAnimals(){
        return animals.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Animal getAnimal(@PathVariable int id)
    {
        return animals.get(id);
    }

    @PostMapping
    public Animal createAnimal(@RequestBody Animal animal){
        animals.put(animal.getId(),animal);
        return animals.get(animal.getId());
    }

    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable Integer id, @RequestBody Animal animal){
        animals.put(id,animal);
        return animals.get(id);
    }

    @DeleteMapping("/{id}")
    public Animal deleteAnimal(@PathVariable Integer id){
        Animal animal = animals.get(id);
        animals.remove(animal.getId());
        return animal;
    }

}
