package com.unibell.clients.controller;

import com.unibell.clients.dto.contact.ContactResponseDTO;
import com.unibell.clients.dto.contact.CreateEmailDTO;
import com.unibell.clients.dto.contact.CreatePhoneDTO;
import com.unibell.clients.entity.ContactType;
import com.unibell.clients.service.ContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client/{id}/contact")
@RequiredArgsConstructor
public class ContactController {
    private final ContactService contactService;

    @GetMapping
    public List<ContactResponseDTO> findContactsByClientIdAndType(
            @PathVariable("id") Long clientId, @RequestParam(name = "type") Optional<String> maybeContactType) {
        
        if (maybeContactType.isPresent()) {
            ContactType contactType = ContactType.fromString(maybeContactType.get());
            return contactService.findContactsByClientIdAndContactType(clientId, contactType);
        }

        return contactService.findContactsByClientId(clientId);
    }

    @PutMapping("/phone")
    public ContactResponseDTO createPhoneForClient(
            @PathVariable("id") Long clientId, @Valid @RequestBody CreatePhoneDTO data) {
        return contactService.create(clientId, data);
    }

    @PutMapping("/email")
    public ContactResponseDTO createEmailForClient(
            @PathVariable("id") Long clientId, @Valid @RequestBody CreateEmailDTO data) {
        return contactService.create(clientId, data);
    }
}
