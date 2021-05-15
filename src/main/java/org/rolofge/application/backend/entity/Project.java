package org.rolofge.application.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name = "projects")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "user_id", nullable = false)
    private String userId;
}
