package org.rolofge.application.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "incomes")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Income {
    @Id
    @GeneratedValue
    private String id;

    @Column(name = "project_id", nullable = false)
    private String projectId;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "income_category_id", nullable = false)
    private String incomeCategoryId;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "income_percentage_id", nullable = false)
    private String outgoingPercentageId;

    @Column
    private float amount;

    @Column(name = "currency_id")
    private String currencyId;
}
