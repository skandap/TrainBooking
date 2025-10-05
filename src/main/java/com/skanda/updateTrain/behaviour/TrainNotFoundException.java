package com.skanda.updateTrain.behaviour;

public class TrainNotFoundException extends RuntimeException {
    public TrainNotFoundException(String msg) {
        super(msg);
    }
}
