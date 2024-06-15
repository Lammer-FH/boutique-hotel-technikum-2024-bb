package com.awt.boutiquehoteltechnikum.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Jacksonized
@Value
public class CustomerDTO {
    @JsonProperty("id")
    @NotNull
    int id;

    @JsonProperty("name")
    @NotNull
    String name;

    @JsonProperty("surname")
    @NotNull
    String surname;

    @JsonProperty("email")
    @NotNull
    String email;

    @JsonProperty("phonenumber")
    @NotNull
    String phonenumber;

    @JsonProperty("address")
    @NotNull
    String address;
}
