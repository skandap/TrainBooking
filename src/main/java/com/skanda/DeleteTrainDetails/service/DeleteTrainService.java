package com.skanda.DeleteTrainDetails.service;

import com.skanda.DeleteTrainDetails.entity.DeleteTrainResponse;

public interface DeleteTrainService {

    DeleteTrainResponse deleteTrain(String trainNumber);
}
