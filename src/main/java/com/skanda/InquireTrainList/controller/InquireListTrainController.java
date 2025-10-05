package com.skanda.InquireTrainList.controller;

import com.skanda.InquireTrainList.entity.InquireListTrainResponse;
import com.skanda.InquireTrainList.service.InquireListTrainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/train_service")
public class InquireListTrainController {

    @Autowired
    public InquireListTrainServiceImpl fetchTrainListService;

    @GetMapping("/fetch_train")
    public ResponseEntity<List<InquireListTrainResponse>> fetchTrainList(@RequestParam(required = false) String sourceStation,
                                                                         @RequestParam(required = false) String destinationStation,
                                                                         @RequestParam(required = false) Double minPrice,
                                                                         @RequestParam(required = false) Double maxPrice) {
        return new ResponseEntity<>(fetchTrainListService.fetchTrainList(sourceStation,destinationStation,minPrice,maxPrice),HttpStatus.OK);
    }
}
