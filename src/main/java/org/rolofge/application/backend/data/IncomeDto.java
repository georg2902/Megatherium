package org.rolofge.application.backend.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.rolofge.application.backend.entity.*;

@Data
@AllArgsConstructor
public class IncomeDto {
    private String id;
    private String userId;
    private String incomeCategoryId;
    private String description;
    private String outgoingPercentageId;
    private float amount;
    private String currencyId;
    private String projectId;

    public IncomeDto of(Income entity) {
        return new IncomeDto(entity.getId(),
                entity.getUserId(),
                entity.getIncomeCategoryId(),
                entity.getDescription(),
                entity.getOutgoingPercentageId(),
                entity.getAmount(),
                entity.getCurrencyId(),
                entity.getProjectId());
    }
}
