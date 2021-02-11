package org.rolofge.application.backend.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "currencies")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Currency {
    @Id
    @GeneratedValue
    private String id;

    @Column(name = "project_id")
    private String projectId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String symbol;

}
