package com.skanda.createTrain.service;

import com.skanda.createTrain.entity.AddTrainRequest;
import com.skanda.createTrain.entity.AddTrainResponse;

public interface AddTrainService {

    AddTrainResponse addTrain(AddTrainRequest trainRequest);
}
