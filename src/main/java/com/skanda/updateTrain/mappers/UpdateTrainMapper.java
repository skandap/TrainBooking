package com.skanda.updateTrain.mappers;

import com.skanda.updateTrain.entity.UpdateTrainEntity;
import com.skanda.updateTrain.entity.UpdateTrainRequest;
import com.skanda.updateTrain.entity.UpdateTrainResponse;
import com.skanda.util.entity.TrainEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface UpdateTrainMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTrainFromRequest(UpdateTrainRequest request, @MappingTarget TrainEntity entity);

    UpdateTrainEntity toUpdateTrainEntity(TrainEntity entity);

    default UpdateTrainResponse toResponse(TrainEntity entity) {
        if (entity == null) return null;
        return UpdateTrainResponse.builder()
                .message("Train updated successfully")
                .updateTrainEntity(toUpdateTrainEntity(entity))
                .build();
    }
}



