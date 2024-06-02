package com.awt.boutiquehoteltechnikum.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Jacksonized
@Value
public class RoomExtraDTO {
    @JsonProperty("id")
    int id;

    @JsonProperty("roomId")
    int roomId;

    @JsonProperty("extraId")
    int extraId;
}
