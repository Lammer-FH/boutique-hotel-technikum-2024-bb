package com.awt.boutiquehoteltechnikum.DTO.Request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import java.time.LocalDate;

@Builder
@Jacksonized
@Value
public class BookingRequestDTO {

    @JsonProperty("title")
    @NotNull
    private String title;

    @JsonProperty("additionalNotes")
    @NotNull
    private String additionalNotes;

    @JsonProperty("customerId")
    @NotNull
    private int customerId;

    @JsonProperty("roomId")
    @NotNull
    private int roomId;

    @JsonProperty("bookingStart")
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate bookingStart;

    @JsonProperty("bookingEnd")
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate bookingEnd;

    @JsonProperty("breakfast")
    @NotNull
    private boolean breakfast;

    @JsonProperty("totalCost")
    @NotNull
    private double totalCost;
}
