package com.example.as4.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class AgentDTO {
    private Long id;
    private String name, role, q, e, c, x;
}
