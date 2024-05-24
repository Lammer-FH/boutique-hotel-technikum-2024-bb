package DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Jacksonized
@Value
public class CustomerDTO {
    @JsonProperty("id")
    int id;

    @JsonProperty("name")
    String name;

    @JsonProperty("surname")
    String surname;

    @JsonProperty("email")
    String email;

    @JsonProperty("phonenumber")
    String phonenumber;

    @JsonProperty("address")
    String address;
}
