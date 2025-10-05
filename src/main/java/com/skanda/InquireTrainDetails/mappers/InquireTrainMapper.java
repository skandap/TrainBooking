package com.skanda.InquireTrainDetails.mappers;

import com.skanda.InquireTrainDetails.entity.InquireTrainResponse;
import com.skanda.util.entity.TrainEntity;
import org.springframework.stereotype.Component;

@Component
public class InquireTrainMapper {

    public InquireTrainResponse toResponse(TrainEntity entity) {
        if (entity == null) return null;

        return InquireTrainResponse.builder()
                .trainId(entity.getTrainId())
                .trainName(entity.getTrainName())
                .trainNumber(entity.getTrainNumber())
                .sourceStation(entity.getSourceStation())
                .destinationStation(entity.getDestinationStation())
                .departureTime(entity.getDepartureTime())
                .arrivalTime(entity.getArrivalTime())
                .availableSeats(entity.getAvailableSeats())
                .ticketPrice(entity.getTicketPrice())
                .build();
    }

}


