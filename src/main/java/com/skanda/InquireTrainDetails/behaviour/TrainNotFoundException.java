package com.skanda.InquireTrainDetails.behaviour;

public class TrainNotFoundException extends RuntimeException {
    public TrainNotFoundException(String msg) {
        super(msg);
    }
}
