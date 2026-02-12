package com.example.as4.controller;

import com.example.as4.model.dto.AgentDTO;
import com.example.as4.service.serviceImpl.AgentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<AgentDTO>> getAll() {
        return ResponseEntity.ok(agentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgentDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(agentService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgentDTO> update(@PathVariable Long id, @RequestBody AgentDTO dto){
        return ResponseEntity.ok(agentService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        agentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}