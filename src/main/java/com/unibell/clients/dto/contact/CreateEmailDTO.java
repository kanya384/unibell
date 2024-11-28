package com.unibell.clients.dto.contact;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateEmailDTO {
    @Email
    @NotBlank
    private String value;
}
