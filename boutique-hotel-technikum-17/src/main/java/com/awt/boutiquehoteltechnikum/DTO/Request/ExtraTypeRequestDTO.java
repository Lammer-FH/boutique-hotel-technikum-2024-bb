package com.awt.boutiquehoteltechnikum.DTO.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Jacksonized
@Value
public class ExtraTypeRequestDTO {
    @NotNull
    @JsonProperty("title")
    String title;

    @NotNull
    @JsonProperty("description")
    String description;
}
