package com.unibell.clients.service;

import com.unibell.clients.dto.contact.ContactResponseDTO;
import com.unibell.clients.dto.contact.CreateEmailDTO;
import com.unibell.clients.dto.contact.CreatePhoneDTO;
import com.unibell.clients.entity.Contact;
import com.unibell.clients.entity.ContactType;
import com.unibell.clients.mapper.ContactMapper;
import com.unibell.clients.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    @Override
    public List<ContactResponseDTO> findContactsByClientId(Long clientId) {
        return contactRepository.findByClientId(clientId).stream()
                .map(contactMapper::map)
                .toList();
    }

    @Override
    public List<ContactResponseDTO> findContactsByClientIdAndContactType(Long clientId, ContactType contactType) {
        List<Contact> contacts = contactRepository.findByClientIdAndContactType(clientId, contactType.toString());
        return contactRepository.findByClientIdAndContactType(clientId, contactType.toString()).stream()
                .map(contactMapper::map)
                .toList();
    }

    @Override
    public ContactResponseDTO create(Long clientId, CreatePhoneDTO phoneDTO) {
        var phone = contactMapper.map(clientId, phoneDTO);
        contactRepository.save(phone);
        return contactMapper.map(phone);
    }

    @Override
    public ContactResponseDTO create(Long clientId, CreateEmailDTO emailDTO) {
        var email = contactMapper.map(clientId, emailDTO);
        contactRepository.save(email);
        return contactMapper.map(email);
    }
}
