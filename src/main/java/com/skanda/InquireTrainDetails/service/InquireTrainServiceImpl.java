package com.skanda.InquireTrainDetails.service;

import com.skanda.InquireTrainDetails.entity.InquireTrainResponse;
import com.skanda.InquireTrainDetails.mappers.InquireTrainMapper;
import com.skanda.updateTrain.behaviour.TrainNotFoundException;
import com.skanda.util.entity.TrainEntity;
import com.skanda.util.repository.TrainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InquireTrainServiceImpl implements InquireTrainService {

    @Autowired
    public final TrainRepository trainRepository;

    @Autowired
    public final InquireTrainMapper inquireTrainMapper;

    @Override
    public InquireTrainResponse fetchTrain(String trainNumber) {
        TrainEntity entity = trainRepository.findByTrainNumber(trainNumber);
        if (entity == null) {
            throw new TrainNotFoundException("Train not found with number: " + trainNumber);
        }
        return inquireTrainMapper.toResponse(entity);
    }
}
