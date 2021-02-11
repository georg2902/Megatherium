package org.rolofge.application.backend.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.rolofge.application.backend.entity.Outgoing;

@Data
@AllArgsConstructor
public class OutgoingDto {
    private String id;
    private int amount;
    private String outgoingCategoryId;
    private String userId;
    private String projectId;

    public OutgoingDto of(Outgoing entity) {
        return new OutgoingDto(entity.getId(), entity.getAmount(), entity.getOutgoingCategoryId(), entity.getUserId(), entity.getProjectId());
    }
}
