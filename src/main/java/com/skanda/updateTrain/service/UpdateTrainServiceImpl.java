package com.skanda.updateTrain.service;

import com.skanda.createTrain.behaviour.SeatsValidation;
import com.skanda.updateTrain.behaviour.TrainNotFoundException;
import com.skanda.updateTrain.entity.UpdateTrainRequest;
import com.skanda.updateTrain.entity.UpdateTrainResponse;
import com.skanda.updateTrain.mappers.UpdateTrainMapper;
import com.skanda.util.entity.TrainEntity;
import com.skanda.util.repository.TrainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateTrainServiceImpl implements UpdateTrainService {

    @Autowired
    public final TrainRepository trainRepository;

    @Autowired
    public final UpdateTrainMapper updateTrainMapper;

    @Override
    public UpdateTrainResponse updateTrain(UpdateTrainRequest trainRequest, String trainNumber) {
        return updateTrain(trainNumber, trainRequest);
    }

    public void seatsValidationCheck(TrainEntity request) {
        if (request.getTotalSeats() < request.getAvailableSeats()) {
            throw new SeatsValidation("Total seats cannot be less than available seats");
        }
    }

    public UpdateTrainResponse updateTrain(String trainNumber, UpdateTrainRequest request) {
        TrainEntity entity = trainRepository.findByTrainNumber(trainNumber);
        if (entity == null) {
            throw new TrainNotFoundException("Train not found with number: " + trainNumber);
        }
        updateTrainMapper.updateTrainFromRequest(request, entity);
        seatsValidationCheck(entity);
        TrainEntity updated = trainRepository.save(entity);
        return updateTrainMapper.toResponse(updated);
    }
}
