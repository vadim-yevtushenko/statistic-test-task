package com.example.statistictesttask.persistence.repository;

import com.example.statistictesttask.persistence.entity.AsinStatisticEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsinStatisticRepository extends MongoRepository<AsinStatisticEntity, String> {
}
