package com.project.Aperetif.Model.enums;

public enum TypeWine {
    GRAPE("Grape"),FRUIT("Fruit"),BERRY("Berry"),
    PLANTED("Planted"),RAISIN("Raisin"),
    MULTI_GRADE("Multi-grade");

    private String name;

    TypeWine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

