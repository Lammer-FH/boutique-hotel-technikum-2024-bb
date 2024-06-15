package com.awt.boutiquehoteltechnikum.DomainModels;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

@Builder
@Jacksonized
@Value
public class CreateBookingCommand {

    private String title;

    private String additionalNotes;

    private int customerId;

    private String roomId;

    private LocalDate bookingStart;

    private LocalDate bookingEnd;

    private boolean breakfast;

    private double totalCost;
}
