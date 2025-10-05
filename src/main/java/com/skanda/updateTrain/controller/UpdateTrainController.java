package com.skanda.updateTrain.controller;
import com.skanda.updateTrain.entity.UpdateTrainRequest;
import com.skanda.updateTrain.entity.UpdateTrainResponse;
import com.skanda.updateTrain.service.UpdateTrainServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/train_service")
public class UpdateTrainController {

    @Autowired
    public UpdateTrainServiceImpl updateTrainService;

    @PutMapping("/update_train/{trainNumber}")
    public ResponseEntity<UpdateTrainResponse> updateTrainDetails(@RequestBody @Valid UpdateTrainRequest updateTrainRequest, @PathVariable String trainNumber) {
        return new ResponseEntity<>(updateTrainService.updateTrain(updateTrainRequest,trainNumber), HttpStatus.CREATED);
    }
}
