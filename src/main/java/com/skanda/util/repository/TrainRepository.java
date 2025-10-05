package com.skanda.util.repository;

import com.skanda.util.entity.TrainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends JpaRepository<TrainEntity,Long> {
    TrainEntity findByTrainNumber(String trainNumber);
}
