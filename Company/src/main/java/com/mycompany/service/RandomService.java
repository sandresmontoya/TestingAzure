package com.mycompany.service;

import com.mycompany.model.Random;
import com.mycompany.repository.RandomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RandomService {

//    @Autowired
    RandomRepository randomRepository;

    public RandomService(RandomRepository randomRepository) {
        this.randomRepository = randomRepository;
    }

    public Random getLucky() {
        return this.randomRepository.getLucky();
    }
}
