package com.skanda.util.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name="train_service")
public class TrainEntity {

    @Id
    private Long trainId;
    private String trainName;
    private String trainNumber;
    private String sourceStation;
    private String destinationStation;
    private LocalTime departureTime; // Format: "08:30"
    private LocalTime arrivalTime; // Format: "18:45"
    private int totalSeats;
    private int availableSeats;
    private double ticketPrice;

    @PrePersist
    public void generateUserId() {
        if (this.trainId == null) {
            this.trainId = ThreadLocalRandom.current().nextLong(10000000L, 99999999L);
        }
    }
}
