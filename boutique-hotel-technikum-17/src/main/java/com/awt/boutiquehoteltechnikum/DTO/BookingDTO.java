package com.awt.boutiquehoteltechnikum.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Builder
@Jacksonized
@Value
public class BookingDTO {
    @JsonProperty("id")
    @NotNull
    private int id;

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

    @JsonProperty("createdAt")
    @NotNull
    private OffsetDateTime createdAt;

    @JsonProperty("bookingStart")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate bookingStart;

    @JsonProperty("bookingEnd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate bookingEnd;

    @JsonProperty("breakfast")
    @NotNull
    private boolean breakfast;

    @JsonProperty("totalCost")
    @NotNull
    private double totalCost;

    @JsonProperty("cancelled")
    @NotNull
    private boolean cancelled;
}
