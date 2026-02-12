package com.example.as4.service.serviceImpl;

import com.example.as4.model.dto.AgentDTO;
import java.util.List;

public interface AgentService {
    AgentDTO create(AgentDTO dto);
    List<AgentDTO> getAll();
    AgentDTO getById(Long id);
    AgentDTO update(Long id, AgentDTO dto);
    void delete(Long id);
}
