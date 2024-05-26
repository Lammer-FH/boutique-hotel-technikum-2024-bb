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

    @JsonProperty("room_id")
    int room_Id;

    @JsonProperty("extra_id")
    int extra_Id;
}
