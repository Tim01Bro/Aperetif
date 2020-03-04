package com.project.Aperetif.Model;

public enum  CategoryEvent {
    WINE_TASTING("Wine tasting"),WINE_TOUR("Wine tour");
    private String name;

    CategoryEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
