package com.skanda.updateTrain.entity;


import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UpdateTrainRequest {
    private String trainName;
    private String sourceStation;
    private String destinationStation;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    @Positive(message = "Total seats must be greater than 0.")
    private Integer totalSeats;
    @PositiveOrZero(message = "Available seats cannot be negative.")
    private Integer availableSeats;
    @Positive(message = "Ticket price must be greater than 0.")
    private Double ticketPrice;
}
