package com.skanda.createTrain.controller;

import com.skanda.createTrain.entity.AddTrainRequest;
import com.skanda.createTrain.entity.AddTrainResponse;
import com.skanda.createTrain.service.AddTrainServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/train_service")
public class AddTrainController {

    @Autowired
    public AddTrainServiceImpl addTrainService;

    @PostMapping("/add_train")
    public ResponseEntity<AddTrainResponse> addNewTrainDetails(@RequestBody @Valid AddTrainRequest addTrainRequest) {
        return new ResponseEntity<>(addTrainService.addTrain(addTrainRequest), HttpStatus.CREATED);
    }
}
