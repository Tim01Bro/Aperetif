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

    public static TypeWine getTypeByName(String name){
        switch (name){
           case "Grape":
                return TypeWine.GRAPE;

            case "Fruit":
                return TypeWine.FRUIT;

            case "Berry":
                return TypeWine.BERRY;

            case "Planted":
                return TypeWine.PLANTED;

            case "Raisin":
                return TypeWine.RAISIN;
            case "Multi-grade":
                return TypeWine.MULTI_GRADE;
            default:
                return null;
        }
    }
}

