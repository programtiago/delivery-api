package com.tiagodeveloper.model;

import com.tiagodeveloper.domain.StatusDelivery;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class DeliveryModel {

    private Long id;
    private String clientName;
    private RecipientModel recipient;
    private BigDecimal tax;
    private StatusDelivery status;
    private OffsetDateTime requestDate;
    private OffsetDateTime completionDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public RecipientModel getRecipient() {
        return recipient;
    }

    public void setRecipient(RecipientModel recipient) {
        this.recipient = recipient;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public StatusDelivery getStatus() {
        return status;
    }

    public void setStatus(StatusDelivery status) {
        this.status = status;
    }

    public OffsetDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(OffsetDateTime requestDate) {
        this.requestDate = requestDate;
    }

    public OffsetDateTime getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(OffsetDateTime completionDate) {
        this.completionDate = completionDate;
    }
}
