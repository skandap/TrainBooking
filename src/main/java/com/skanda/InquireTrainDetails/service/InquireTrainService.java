package com.skanda.InquireTrainDetails.service;

import com.skanda.InquireTrainDetails.entity.InquireTrainResponse;

public interface InquireTrainService {

    InquireTrainResponse fetchTrain(String trainNumber);
}
