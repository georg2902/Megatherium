package org.rolofge.application.backend.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.rolofge.application.backend.entity.OutgoingCategory;

@Data
@AllArgsConstructor
public class OutgoingCategoryDto {
    private String id;
    private int amount;
    private String projectId;
    private String userId;

    public OutgoingCategoryDto of(OutgoingCategory entity){
        return new OutgoingCategoryDto(entity.getId(), entity.getAmount(), entity.getProjectId(), entity.getUserId());
    }
}
