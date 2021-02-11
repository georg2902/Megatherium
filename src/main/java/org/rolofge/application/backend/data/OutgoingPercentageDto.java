package org.rolofge.application.backend.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.rolofge.application.backend.entity.OutgoingPercentage;

@Data
@AllArgsConstructor
public class OutgoingPercentageDto {
    private String id;
    private String name;
    private float percentage;
    private String userId;
    private String projectId;

    public OutgoingPercentageDto of(OutgoingPercentage entity) {
        return new OutgoingPercentageDto(entity.getId(), entity.getName(), entity.getPercentage(), entity.getUserId(), entity.getProjectId());
    }
}
