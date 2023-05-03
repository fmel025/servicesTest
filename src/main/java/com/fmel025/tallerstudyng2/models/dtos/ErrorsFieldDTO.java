package com.fmel025.tallerstudyng2.models.dtos;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ErrorsFieldDTO {
    private String field;
    private List<String> messages;

    public ErrorsFieldDTO(String field) {
        super();
        this.field = field;
        this.messages = new ArrayList<>();
    }
}
