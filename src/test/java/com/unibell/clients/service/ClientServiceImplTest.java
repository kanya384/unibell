package com.unibell.clients.service;

import com.unibell.clients.dto.client.ClientResponseDTO;
import com.unibell.clients.entity.Client;
import com.unibell.clients.mapper.ClientMapperImpl;
import com.unibell.clients.repository.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Import(ClientMapperImpl.class)
public class ClientServiceImplTest {

    private ClientService clientService;

    @Mock
    private ClientRepository clientRepository;

    @BeforeEach
    public void setUp() {
        clientService = new ClientServiceImpl(clientRepository, new ClientMapperImpl());
    }

    @Test
    public void shouldReturnClientsList() {
        when(clientRepository.findAll())
                .thenAnswer(invocationOnMock -> {
                    List<Client> clients = new ArrayList<>();
                    Client client1 = new Client();
                    client1.setId(1L);
                    client1.setName("test - 1");

                    Client client2 = new Client();
                    client2.setId(1L);
                    client2.setName("test - 2");

                    clients.add(client1);
                    clients.add(client2);
                    return clients;
                });
        List<ClientResponseDTO> clients = clientService.findAll();

        Assertions.assertEquals(2, clients.size());
    }
}
