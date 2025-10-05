package com.skanda.updateTrain.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UpdateTrainResponse {

    public String message;
    public UpdateTrainEntity updateTrainEntity;
}
