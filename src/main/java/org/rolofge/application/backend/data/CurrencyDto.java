package org.rolofge.application.backend.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.rolofge.application.backend.entity.Currency;

@Data
@AllArgsConstructor
public class CurrencyDto {
    private String id;
    private String name;
    private String symbol;
    private String projectId;

    public CurrencyDto of(Currency currency) {
        return new CurrencyDto(
                currency.getId(),
                currency.getName(),
                currency.getSymbol(),
                currency.getProjectId());
    }
}
