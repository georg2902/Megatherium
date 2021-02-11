package org.rolofge.application.backend.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.rolofge.application.backend.entity.IncomeCategory;

@Data
@AllArgsConstructor
public class IncomeCategoryDto {
    private String id;
    private String name;
    private String projectId;
    private String userId;

    public IncomeCategoryDto of(IncomeCategory entity) {
        return new IncomeCategoryDto(entity.getId(), entity.getName(), entity.getProjectId(), entity.getUserId());
    }
}
