package com.unibell.clients.mapper;

import com.unibell.clients.dto.client.ClientDetailedDTO;
import com.unibell.clients.dto.client.ClientResponseDTO;
import com.unibell.clients.dto.client.CreateClientDTO;
import com.unibell.clients.dto.contact.ContactResponseDTO;
import com.unibell.clients.entity.Client;
import com.unibell.clients.entity.Contact;
import org.mapstruct.*;

@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class ClientMapper {
    public abstract Client map(CreateClientDTO dto);

    public abstract ClientResponseDTO map(Client client);

    public abstract ClientDetailedDTO mapDetailed(Client client);


    @AfterMapping
    void setType(Contact contact, @MappingTarget ContactResponseDTO dto) {
        dto.setType(contact.getClass().getSimpleName().toLowerCase());
    }
}
