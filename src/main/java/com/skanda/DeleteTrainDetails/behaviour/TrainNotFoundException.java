package com.skanda.DeleteTrainDetails.behaviour;

public class TrainNotFoundException extends RuntimeException {
    public TrainNotFoundException(String msg) {
        super(msg);
    }
}
