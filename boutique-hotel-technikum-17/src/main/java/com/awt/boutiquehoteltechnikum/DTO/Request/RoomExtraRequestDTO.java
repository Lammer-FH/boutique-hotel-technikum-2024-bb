package com.awt.boutiquehoteltechnikum.DTO.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Jacksonized
@Value
public class RoomExtraRequestDTO {
    @JsonProperty("roomId")
    @NotNull
    int roomId;

    @JsonProperty("extraId")
    @NotNull
    int extraId;
}
