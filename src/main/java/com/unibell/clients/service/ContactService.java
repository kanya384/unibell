package com.unibell.clients.service;

import com.unibell.clients.dto.contact.ContactResponseDTO;
import com.unibell.clients.dto.contact.CreateEmailDTO;
import com.unibell.clients.dto.contact.CreatePhoneDTO;
import com.unibell.clients.entity.ContactType;

import java.util.List;

public interface ContactService {
    List<ContactResponseDTO> findContactsByClientId(Long clientId);

    List<ContactResponseDTO> findContactsByClientIdAndContactType(Long id, ContactType contactType);

    ContactResponseDTO create(Long clientId, CreatePhoneDTO phone);

    ContactResponseDTO create(Long clientId, CreateEmailDTO email);
}
