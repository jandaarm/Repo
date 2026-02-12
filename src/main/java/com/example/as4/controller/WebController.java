package com.example.as4.controller;

import com.example.as4.model.dto.AgentDTO;
import com.example.as4.service.serviceImpl.AgentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    private final AgentService agentService;

    public WebController(AgentService agentService) {
        this.agentService = agentService;
    }


    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Agent Manager");
        return "index";
    }

    @GetMapping("/agents-page")
    public String agentsPage(Model model) {
        model.addAttribute("agents", agentService.getAll());
        return "agents";
    }

    @GetMapping("/add-agent")
    public String addAgentPage() {
        return "add-agent";
    }

    @PostMapping("/add-agent")
    public String addAgent(AgentDTO dto) {
        agentService.create(dto);
        return "redirect:/agents-page";
    }

    @PostMapping("/delete-agent/{id}")
    public String deleteAgent(@PathVariable Long id) {
        agentService.delete(id);
        return "redirect:/agents-page";
    }

    @GetMapping("/edit-agent/{id}")
    public String editAgentPage(@PathVariable Long id, Model model) {
        model.addAttribute("agent", agentService.getById(id));
        return "edit-agent";
    }

    @PostMapping("/edit-agent/{id}")
    public String updateAgent(@PathVariable Long id, AgentDTO dto) {
        agentService.update(id, dto);
        return "redirect:/agents-page";
    }


}
