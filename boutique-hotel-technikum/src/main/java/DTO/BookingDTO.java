package DTO;

import Model.Booking;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Builder
@Value
public class BookingDTO {
    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("additional_notes")
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

    public static BookingDTO fromEntity(Booking booking) {
        return BookingDTO.builder()
                .id(booking.getId())
                .title(booking.getTitle())
                .additionalNotes(booking.getAdditional_notes())
                .customerId(booking.getCustomer_id())
                .roomId(booking.getRoom_id())
                .createdAt(LocalDate.parse(booking.getCreated_at()))
                .bookingStart(LocalDate.parse(booking.getBooking_start()))
                .bookingEnd(LocalDate.parse(booking.getBooking_end()))
                .breakfast(booking.isBreakfast())
                .totalCost(booking.getTotal_cost())
                .cancelled(booking.isCancelled())
                .build();
    }
}
