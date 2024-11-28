package com.unibell.clients.controller;

import com.unibell.clients.dto.client.ClientDetailedDTO;
import com.unibell.clients.dto.client.ClientResponseDTO;
import com.unibell.clients.dto.client.CreateClientDTO;
import com.unibell.clients.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    @GetMapping
    public List<ClientResponseDTO> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public ClientDetailedDTO findById(@PathVariable("id") Long clientId) {
        return clientService.findById(clientId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDetailedDTO create(@Valid @RequestBody CreateClientDTO data) {
        return clientService.create(data);
    }
}
