package com.skanda.DeleteTrainDetails.service;

import com.skanda.DeleteTrainDetails.entity.DeleteTrainResponse;
import com.skanda.updateTrain.behaviour.TrainNotFoundException;
import com.skanda.util.entity.TrainEntity;
import com.skanda.util.repository.TrainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteTrainServiceImpl implements DeleteTrainService {

    @Autowired
    public final TrainRepository trainRepository;

    @Override
    public DeleteTrainResponse deleteTrain(String trainNumber) {
        TrainEntity entity = trainRepository.findByTrainNumber(trainNumber);
        if (entity == null) {
            throw new TrainNotFoundException("Train not found with number: " + trainNumber);
        }
        trainRepository.deleteById(entity.getTrainId());
        return DeleteTrainResponse.builder().message("The train data of number: " + trainNumber +" deleted successfully").build();
    }
}
