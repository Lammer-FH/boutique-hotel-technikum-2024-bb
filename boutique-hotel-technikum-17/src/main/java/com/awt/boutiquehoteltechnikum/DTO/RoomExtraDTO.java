package com.awt.boutiquehoteltechnikum.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Jacksonized
@Value
public class RoomExtraDTO {
    @JsonProperty("id")
    @NotNull
    int id;

    @JsonProperty("roomId")
    @NotNull
    int roomId;

    @JsonProperty("extraId")
    @NotNull
    int extraId;
}
