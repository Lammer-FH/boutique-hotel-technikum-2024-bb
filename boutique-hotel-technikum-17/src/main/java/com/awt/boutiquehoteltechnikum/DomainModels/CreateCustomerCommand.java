package com.awt.boutiquehoteltechnikum.DomainModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Jacksonized
@Value
public class CreateCustomerCommand {
    String name;

    String surname;

    String email;

    String phonenumber;

    String address;
}
