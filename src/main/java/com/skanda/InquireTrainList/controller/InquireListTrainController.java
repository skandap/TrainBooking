package com.skanda.InquireTrainList.controller;

import com.skanda.InquireTrainList.entity.InquireListTrainResponse;
import com.skanda.InquireTrainList.service.InquireListTrainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    //offset=10 means it will skip 1st 10 values and gives 11 to 15
    //offset=(pg.no-1)x page.size
    //if we want to fetch 4th page values offset will skip 1st 15 values and give next 5 i.e 15 to 20
    //Sort function we can use to sort by price,sourcestation etc on accending/decending

    @GetMapping("/fetch_train")
    public ResponseEntity<List<InquireListTrainResponse>> fetchTrainList(@RequestParam(required = false) String sourceStation,
                                                                         @RequestParam(required = false) String destinationStation,
                                                                         @RequestParam(required = false) Double minPrice,
                                                                         @RequestParam(required = false) Double maxPrice,
                                                                         @RequestParam(required = false, defaultValue = "1") int pageNo,
                                                                         @RequestParam(required = false, defaultValue = "5") int pageSize,
                                                                         @RequestParam(required = false, defaultValue = "trainName") String sortBy,
                                                                         @RequestParam(required = false, defaultValue = "ASC") String sortDir) {
        //logic
        Sort sort = null;
        if (sortDir.equalsIgnoreCase("ASC")) {
            sort = Sort.by(sortBy).ascending();
        } else {
            sort = Sort.by(sortBy).descending();
        }
        return new ResponseEntity<>(fetchTrainListService.fetchTrainList(sourceStation, destinationStation, minPrice, maxPrice, PageRequest.of(pageNo - 1, pageSize, sort)), HttpStatus.OK);
    }
}
