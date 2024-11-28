package com.unibell.clients.service;

import com.unibell.clients.dto.client.ClientDetailedDTO;
import com.unibell.clients.dto.client.ClientResponseDTO;
import com.unibell.clients.dto.client.CreateClientDTO;
import com.unibell.clients.exception.ResourceNotFoundException;
import com.unibell.clients.mapper.ClientMapper;
import com.unibell.clients.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public List<ClientResponseDTO> findAll() {
        return clientRepository.findAll().stream()
                .map(clientMapper::map)
                .toList();
    }

    @Override
    public ClientDetailedDTO findById(Long id) {
        return clientRepository.findById(id)
                .map(clientMapper::mapDetailed)
                .orElseThrow(() -> new ResourceNotFoundException("Client", id));
    }

    @Override
    public ClientDetailedDTO create(CreateClientDTO clientDTO) {
        var client = clientMapper.map(clientDTO);
        clientRepository.save(client);
        return clientMapper.mapDetailed(client);
    }
}
