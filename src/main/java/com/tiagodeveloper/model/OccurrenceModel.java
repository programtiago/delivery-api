package com.tiagodeveloper.model;

import java.time.OffsetDateTime;

public class OccurrenceModel {

    private Long id;
    private String description;
    private OffsetDateTime registryDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OffsetDateTime getRegistryDate() {
        return registryDate;
    }

    public void setRegistryDate(OffsetDateTime registryDate) {
        this.registryDate = registryDate;
    }
}
