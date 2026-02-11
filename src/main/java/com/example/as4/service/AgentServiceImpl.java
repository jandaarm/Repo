package com.example.as4.service;

import com.example.as4.model.dto.AgentDTO;
import com.example.as4.model.entity.Agent;
import com.example.as4.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentServiceImpl implements AgentService{

    private final AgentRepository agentRepository;

    @Autowired
    public AgentServiceImpl (AgentRepository agentRepository) {this.agentRepository = agentRepository;}

    @Override
    public AgentDTO create(AgentDTO dto){
        Agent agent = Agent.builder() // converts dto-object into entity-object(created agent)
                .name(dto.getName())
                .role(dto.getRole())
                .q(dto.getQ())
                .e(dto.getE())
                .c(dto.getC())
                .x(dto.getX())
                .build();
        agent = agentRepository.save(agent); //method "save" inserts created agent(using created agent) into DB and then returns saved agent
                return mapToDTO(agent); //(using saved agent)
    }

    //converts saved entity-agent into dto-object to return to user
    public AgentDTO mapToDTO(Agent agent){
        return AgentDTO.builder()
                .id(agent.getId())
                .name(agent.getName())
                .role(agent.getRole())
                .q(agent.getQ())
                .e(agent.getE())
                .c(agent.getC())
                .x(agent.getX())
                .build();
    }
}

