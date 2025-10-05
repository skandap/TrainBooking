package com.skanda.createTrain.service;

import com.skanda.createTrain.behaviour.SeatsValidation;
import com.skanda.createTrain.behaviour.TrainDuplicateException;
import com.skanda.createTrain.entity.AddTrainRequest;
import com.skanda.createTrain.entity.AddTrainResponse;
import com.skanda.createTrain.mappers.AddTrainMapper;
import com.skanda.util.entity.TrainEntity;
import com.skanda.util.repository.TrainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AddTrainServiceImpl implements AddTrainService {

    @Autowired
    public final TrainRepository trainRepository;

    @Autowired
    public final AddTrainMapper addTrainMapper;

    @Override
    public AddTrainResponse addTrain(AddTrainRequest trainRequest) {
        ifDuplicateExists(trainRequest);
        seatsValidationCheck(trainRequest);
        TrainEntity trainEntity = addTrainMapper.toEntity(trainRequest);
        trainRepository.save(trainEntity);
        return addTrainMapper.toResponse(trainEntity);
    }

    public void ifDuplicateExists(AddTrainRequest request) {
        TrainEntity entity = trainRepository.findByTrainNumber(request.getTrainNumber());
        if (entity != null) {
            if (Objects.equals(request.getTrainNumber(), entity.getTrainNumber())) {
                throw new TrainDuplicateException("Train with this number already Registered");
            }
        }
    }

    public void seatsValidationCheck(AddTrainRequest request)
    {
        if(request.getTotalSeats()<request.getAvailableSeats())
        {
            throw new SeatsValidation("Total seats cannot be less than available seats");
        }
    }
}
