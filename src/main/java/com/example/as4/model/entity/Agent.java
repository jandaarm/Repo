package com.example.as4.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "agents")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name, role, q, e, c, x;
}
