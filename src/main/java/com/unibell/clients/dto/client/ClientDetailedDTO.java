package com.unibell.clients.dto.client;

import com.unibell.clients.dto.contact.ContactResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClientDetailedDTO {
    private Long id;

    private String name;

    private List<ContactResponseDTO> contacts;
}
