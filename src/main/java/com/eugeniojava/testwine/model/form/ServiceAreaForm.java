package com.eugeniojava.testwine.model.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

public class ServiceAreaForm {
    @Positive
    private final Long storeId;

    @Positive
    @Min(value = 10000000L)
    @Max(value = 99999999L)
    private final Long startRange;

    @Positive
    @Min(value = 10000000L)
    @Max(value = 99999999L)
    private final Long endRange;

    public ServiceAreaForm(Long storeId, Long startRange, Long endRange) {
        this.storeId = storeId;
        this.startRange = startRange;
        this.endRange = endRange;
    }

    public Long getStoreId() {
        return storeId;
    }

    public Long getStartRange() {
        return startRange;
    }

    public Long getEndRange() {
        return endRange;
    }
}
