package com.unibell.clients.dto.client;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateClientDTO {
    @NotBlank
    private String name;
}
