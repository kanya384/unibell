package com.unibell.clients.controller;

import com.unibell.clients.entity.Client;
import com.unibell.clients.mapper.ClientMapper;
import com.unibell.clients.mapper.ClientMapperImpl;
import com.unibell.clients.service.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ClientController.class)
@Import(ClientMapperImpl.class)
public class ClientControllerTest {
    @Autowired
    private ClientMapper mapper;

    @MockitoBean
    private ClientService clientService;

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldReturnClientsList() throws Exception {
        when(clientService.findAll())
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

        mvc.perform(get("/client")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", is(2), Integer.class));
    }
}
