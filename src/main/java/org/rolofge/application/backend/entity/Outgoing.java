package org.rolofge.application.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "outgoings")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Outgoing {
    @Id
    @GeneratedValue
    private String id;

    @Column(name = "project_id")
    private String projectId;

    @Column
    private int amount;

    @Column(name = "outgoing_category_id", nullable = false)
    private String outgoingCategoryId;

    @Column(name = "user_id", nullable = false)
    private String userId;
}
