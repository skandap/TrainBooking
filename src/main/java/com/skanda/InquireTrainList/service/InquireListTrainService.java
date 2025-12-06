package com.skanda.InquireTrainList.service;

import com.skanda.InquireTrainList.entity.InquireListTrainResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InquireListTrainService {

    List<InquireListTrainResponse> fetchTrainList(String sourceStation, String destinationStation, Double minPrice, Double maxPrice, Pageable pageable);
}
