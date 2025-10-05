package com.skanda.InquireTrainDetails.controller;

import com.skanda.InquireTrainDetails.entity.InquireTrainResponse;
import com.skanda.InquireTrainDetails.service.InquireTrainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/train_service")
public class InquireTrainController {

    @Autowired
    public InquireTrainServiceImpl fetchTrainService;

    @GetMapping("/fetch_train/{trainNumber}")
    public ResponseEntity<InquireTrainResponse> fetchTrainDetails(@PathVariable String trainNumber) {
        return new ResponseEntity<>(fetchTrainService.fetchTrain(trainNumber), HttpStatus.OK);
    }
}
