package com.awt.boutiquehoteltechnikum.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

@Builder
@Jacksonized
@Value
public class BookingDTO {
    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("additionalNotes")
    private String additionalNotes;

    @JsonProperty("customerId")
    private int customerId;

    @JsonProperty("roomId")
    private String roomId;

    @JsonProperty("createdAt")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;

    @JsonProperty("bookingStart")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate bookingStart;

    @JsonProperty("bookingEnd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate bookingEnd;

    @JsonProperty("breakfast")
    private boolean breakfast;

    @JsonProperty("totalCost")
    private double totalCost;

    @JsonProperty("cancelled")
    private boolean cancelled;
}
