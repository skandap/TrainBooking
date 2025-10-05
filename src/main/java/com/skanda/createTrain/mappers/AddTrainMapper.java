package com.skanda.createTrain.mappers;

import com.skanda.createTrain.entity.AddTrainRequest;
import com.skanda.createTrain.entity.AddTrainResponse;
import com.skanda.util.entity.TrainEntity;
import org.springframework.stereotype.Component;

@Component
public class AddTrainMapper {

    public TrainEntity toEntity(AddTrainRequest request) {
        if (request == null) return null;

        return TrainEntity.builder()
                .trainName(request.getTrainName())
                .trainNumber(request.getTrainNumber())
                .sourceStation(request.getSourceStation())
                .destinationStation(request.getDestinationStation())
                .departureTime(request.getDepartureTime())
                .arrivalTime(request.getArrivalTime())
                .totalSeats(request.getTotalSeats())
                .availableSeats(request.getAvailableSeats())
                .ticketPrice(request.getTicketPrice())
                .build();
    }

    public AddTrainResponse toResponse(TrainEntity entity) {
        if (entity == null) return null;

        return AddTrainResponse.builder()
                .trainId(entity.getTrainId())
                .trainName(entity.getTrainName())
                .trainNumber(entity.getTrainNumber())
                .sourceStation(entity.getSourceStation())
                .destinationStation(entity.getDestinationStation())
                .departureTime(entity.getDepartureTime())
                .arrivalTime(entity.getArrivalTime())
                .totalSeats(entity.getTotalSeats())
                .availableSeats(entity.getAvailableSeats())
                .ticketPrice(entity.getTicketPrice())
                .build();
    }

}


