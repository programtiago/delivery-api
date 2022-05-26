package com.tiagodeveloper.model.input;

import javax.validation.constraints.NotBlank;

public class OccurrenceInput {

    @NotBlank
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
