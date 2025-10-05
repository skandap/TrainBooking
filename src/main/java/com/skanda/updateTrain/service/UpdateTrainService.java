package com.skanda.updateTrain.service;

import com.skanda.updateTrain.entity.UpdateTrainRequest;
import com.skanda.updateTrain.entity.UpdateTrainResponse;

public interface UpdateTrainService {

    UpdateTrainResponse updateTrain(UpdateTrainRequest trainRequest,String trainNumber);
}
