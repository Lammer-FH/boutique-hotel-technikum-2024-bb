package com.awt.boutiquehoteltechnikum.DTO.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Jacksonized
@Value
public class RoomRequestDTO {
    @JsonProperty("title")
    @NotNull
    String title;

    @JsonProperty("description")
    @NotNull
    String description;

    @JsonProperty("price")
    @NotNull
    double price;

    @JsonProperty("roomType")
    @NotNull
    String roomType;

    @JsonProperty("bedType")
    @NotNull
    String bedType;

    @JsonProperty("bedCount")
    @NotNull
    int bedCount;

    @JsonProperty("image")
    @NotNull
    String image;
}
