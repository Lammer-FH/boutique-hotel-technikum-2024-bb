package com.awt.boutiquehoteltechnikum.DTO.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Jacksonized
@Value
public class CustomerRequestDTO {
    @NotNull
    @JsonProperty("name")
    String name;

    @NotNull
    @JsonProperty("surname")
    String surname;

    @NotNull
    @Email
    @JsonProperty("email")
    String email;

    @NotNull
    @JsonProperty("phonenumber")
    String phonenumber;

    @NotNull
    @JsonProperty("address")
    String address;
}
