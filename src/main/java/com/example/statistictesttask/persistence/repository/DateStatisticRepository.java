package com.example.statistictesttask.persistence.repository;

import com.example.statistictesttask.persistence.entity.DateStatisticEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateStatisticRepository extends MongoRepository<DateStatisticEntity, String> {
}
