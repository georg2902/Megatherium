package org.rolofge.application.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "income_percentages")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OutgoingPercentage {

    @Id
    @GeneratedValue
    private String id;

    @Column(name = "project_id")
    private String projectId;

    @Column(name = "user_id")
    private String userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private float percentage;
}
