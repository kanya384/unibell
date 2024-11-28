package com.unibell.clients.dto.contact;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePhoneDTO {
    @NotBlank
    @Pattern(regexp = "(^$|[0-9]{11})")
    private String value;
}
