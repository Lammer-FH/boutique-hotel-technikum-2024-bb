package com.awt.boutiquehoteltechnikum.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Jacksonized
@Value
public class RoomDTO {
    @JsonProperty("id")
    @NotNull
    int id;

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
