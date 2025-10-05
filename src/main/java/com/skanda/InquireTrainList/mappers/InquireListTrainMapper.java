package com.skanda.InquireTrainList.mappers;

import com.skanda.InquireTrainList.entity.InquireListTrainResponse;
import com.skanda.util.entity.TrainEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InquireListTrainMapper {

    public List<InquireListTrainResponse> toResponse(List<TrainEntity> entity) {
        List<InquireListTrainResponse> inquireListTrainResponses = new ArrayList<>();
        for (TrainEntity e : entity) {
            InquireListTrainResponse response = InquireListTrainResponse.builder()
                    .trainId(e.getTrainId())
                    .trainName(e.getTrainName())
                    .trainNumber(e.getTrainNumber())
                    .sourceStation(e.getSourceStation())
                    .destinationStation(e.getDestinationStation())
                    .departureTime(e.getDepartureTime())
                    .arrivalTime(e.getArrivalTime())
                    .availableSeats(e.getAvailableSeats())
                    .ticketPrice(e.getTicketPrice())
                    .build();
            inquireListTrainResponses.add(response);
        }
        return inquireListTrainResponses;
    }
}


