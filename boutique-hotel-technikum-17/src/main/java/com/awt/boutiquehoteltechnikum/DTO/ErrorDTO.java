package com.awt.boutiquehoteltechnikum.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.antlr.v4.runtime.misc.NotNull;

@Builder
@Jacksonized
@Value
public class ErrorDTO {
    private String message;

    private int status;
    private String detail;
    private String instance;

    public ErrorDTO(String message, int status, String detail, String instance) {
        this.message = message;
        this.status = status;
        this.detail = detail;
        this.instance = instance;

    }
}
