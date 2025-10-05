package com.skanda.createTrain.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class AddTrainRequest {
    @NotBlank(message = "Train name is required.")
    private String trainName;

    @NotBlank(message = "Train number is required.")
    private String trainNumber;

    @NotBlank(message = "Source station is required.")
    private String sourceStation;

    @NotBlank(message = "Destination station is required.")
    private String destinationStation;

    @NotNull(message = "Departure time is required.")
    private LocalTime departureTime;

    @NotNull(message = "Arrival time is required.")
    private LocalTime arrivalTime;

    @NotNull(message = "Total Seats is required.")
    @Positive(message = "Total seats must be greater than 0.")
    private Integer totalSeats;

    @NotNull(message = "Available seats is required.")
    @PositiveOrZero(message = "Available seats cannot be negative.")
    private Integer availableSeats;

    @NotNull(message = "Ticket price is required.")
    @Positive(message = "Ticket price must be greater than 0.")
    private Double ticketPrice;
}
