package com.mycompany.repository;

import com.mycompany.model.Random;
import org.springframework.stereotype.Repository;

@Repository
public interface RandomRepository {
    Random getLucky();
}
