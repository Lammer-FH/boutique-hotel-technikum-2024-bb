package com.awt.boutiquehoteltechnikum.DTO.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Jacksonized
@Value
public class RoomExtraRequestDTO {
    @JsonProperty("roomId")
    int roomId;

    @JsonProperty("extraId")
    int extraId;
}
