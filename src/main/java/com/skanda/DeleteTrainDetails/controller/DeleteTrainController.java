package com.skanda.DeleteTrainDetails.controller;
import com.skanda.DeleteTrainDetails.entity.DeleteTrainResponse;
import com.skanda.DeleteTrainDetails.service.DeleteTrainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/train_service")
public class DeleteTrainController {

    @Autowired
    public DeleteTrainServiceImpl deleteTrainService;

    @DeleteMapping("/delete_train/{trainNumber}")
    public ResponseEntity<DeleteTrainResponse> deleteTrainDetails(@PathVariable String trainNumber) {
        return new ResponseEntity<>(deleteTrainService.deleteTrain(trainNumber), HttpStatus.OK);
    }
}
