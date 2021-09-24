package com.eugeniojava.testwine.model.form;

import javax.validation.constraints.NotBlank;

public class StoreForm {
    @NotBlank
    private final String name;

    public StoreForm(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
