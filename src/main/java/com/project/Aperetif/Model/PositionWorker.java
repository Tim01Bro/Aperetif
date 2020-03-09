package com.project.Aperetif.Model;

public enum  PositionWorker {
    WINEMAKER_JUNIOR("Winemaker Junior"),WINEMAKER_SENIOR("Senior Winemaker"),WINE_CRITIC("Wine Critic");
    private String name;

    PositionWorker(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
