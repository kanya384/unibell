package com.unibell.clients.service;

import com.unibell.clients.dto.client.ClientDetailedDTO;
import com.unibell.clients.dto.client.ClientResponseDTO;
import com.unibell.clients.dto.client.CreateClientDTO;

import java.util.List;

public interface ClientService {
    List<ClientResponseDTO> findAll();

    ClientDetailedDTO findById(Long id);

    ClientDetailedDTO create(CreateClientDTO clientDTO);
}
