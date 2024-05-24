package DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Jacksonized
@Value
public class RoomDTO {
    @JsonProperty("id")
    int id;

    @JsonProperty("title")
    String title;

    @JsonProperty("description")
    String description;

    @JsonProperty("price")
    double price;

    @JsonProperty("room_type")
    String roomType;

    @JsonProperty("bed_type")
    String bedType;

    @JsonProperty("bed_count")
    int bedCount;

    @JsonProperty("image")
    String image;
}
