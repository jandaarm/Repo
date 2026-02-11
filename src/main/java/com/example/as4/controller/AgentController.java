package com.example.as4.controller;

import com.example.as4.model.dto.AgentDTO;
import com.example.as4.service.AgentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/agent")
public class AgentController {

    private final AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @PostMapping
    public ResponseEntity<AgentDTO> create(@RequestBody AgentDTO dto){
        return ResponseEntity.ok(agentService.create(dto));
    }

}