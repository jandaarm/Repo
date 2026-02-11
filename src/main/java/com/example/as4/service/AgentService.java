package com.example.as4.service;

import com.example.as4.model.dto.AgentDTO;
import org.springframework.stereotype.Service;

public interface AgentService {
    AgentDTO create(AgentDTO dto);
}
