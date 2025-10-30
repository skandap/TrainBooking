package com.skanda.InquireTrainDetails.controller;

import com.skanda.InquireTrainDetails.entity.InquireTrainResponse;
import com.skanda.updateTrain.behaviour.TrainNotFoundException;
import com.skanda.util.entity.TrainEntity;
import com.skanda.util.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/internal/train")
public class InternalTrainController {

    @Autowired
    public TrainRepository trainRepository;

    @GetMapping("/{trainId}")
    public ResponseEntity<InquireTrainResponse> fetchTrainDetails(@PathVariable Long trainId) {

        TrainEntity entity=trainRepository.findById(trainId).orElseThrow(()->new TrainNotFoundException("No train Found for id "+trainId));
        InquireTrainResponse inquireTrainResponse=new InquireTrainResponse();
        inquireTrainResponse.setTrainId(trainId);
        inquireTrainResponse.setTrainName(entity.getTrainName());
        inquireTrainResponse.setTrainNumber(entity.getTrainNumber());
        inquireTrainResponse.setSourceStation(entity.getSourceStation());
        inquireTrainResponse.setDestinationStation(entity.getDestinationStation());
        return ResponseEntity.ok(inquireTrainResponse);
    }
}
