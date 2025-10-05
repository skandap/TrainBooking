package com.skanda.InquireTrainDetails.entity;

import lombok.*;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class InquireTrainResponse {

    private Long trainId;
    private String trainName;
    private String trainNumber;
    private String sourceStation;
    private String destinationStation;
    private LocalTime departureTime;
    private LocalTime  arrivalTime;
    private int availableSeats;
    private double ticketPrice;
}
