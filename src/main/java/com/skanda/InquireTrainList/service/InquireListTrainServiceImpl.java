package com.skanda.InquireTrainList.service;

import com.skanda.InquireTrainList.entity.InquireListTrainResponse;
import com.skanda.InquireTrainList.mappers.InquireListTrainMapper;
import com.skanda.util.entity.TrainEntity;
import com.skanda.util.repository.TrainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InquireListTrainServiceImpl implements InquireListTrainService {

    @Autowired
    public final TrainRepository trainRepository;

    @Autowired
    public final InquireListTrainMapper inquireTrainMapper;

    @Override
    public List<InquireListTrainResponse> fetchTrainList(String sourceStation, String destinationStation, Double minPrice, Double maxPrice) {
        List<TrainEntity> entity = trainRepository.findAll();
        List<InquireListTrainResponse> inquireTrainResponses= inquireTrainMapper.toResponse(entity);
        return inquireTrainResponses.stream().filter(train->sourceStation==null||train.getSourceStation().equalsIgnoreCase(sourceStation))
                .filter(train-> destinationStation==null||train.getDestinationStation().equalsIgnoreCase(destinationStation))
                .filter(train->minPrice==null||train.getTicketPrice()>=minPrice)
                .filter(trainRepository->maxPrice==null|| trainRepository.getTicketPrice()<=maxPrice)
                .toList();
    }
}
