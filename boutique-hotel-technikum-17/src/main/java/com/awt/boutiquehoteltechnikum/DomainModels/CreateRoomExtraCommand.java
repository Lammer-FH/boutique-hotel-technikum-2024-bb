package com.awt.boutiquehoteltechnikum.DomainModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Jacksonized
@Value
public class CreateRoomExtraCommand {
    int roomId;
    int extraId;
}
