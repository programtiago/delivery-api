package com.tiagodeveloper.model.input;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class DeliveryInputModel {

    @Valid
    @NotNull
    private ClientIdInput client;

    @Valid
    @NotNull
    private RecipientInput recipient;

    private BigDecimal tax;

}
