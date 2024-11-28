package com.unibell.clients.mapper;

import com.unibell.clients.dto.contact.ContactResponseDTO;
import com.unibell.clients.dto.contact.CreateEmailDTO;
import com.unibell.clients.dto.contact.CreatePhoneDTO;
import com.unibell.clients.entity.Contact;
import com.unibell.clients.entity.Email;
import com.unibell.clients.entity.Phone;
import org.mapstruct.*;

@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class ContactMapper {
    @Mapping(target = "client.id", source = "clientId")
    public abstract Phone map(Long clientId, CreatePhoneDTO dto);

    @Mapping(target = "client.id", source = "clientId")
    public abstract Email map(Long clientId, CreateEmailDTO dto);

    @Mapping(target = "id", source = "id") //какой-то баг c id, пришлось мапить
    public abstract ContactResponseDTO map(Contact contact);

    @AfterMapping
    void setType(Contact contact, @MappingTarget ContactResponseDTO dto) {
        dto.setType(contact.getClass().getSimpleName().toLowerCase());
    }
}
