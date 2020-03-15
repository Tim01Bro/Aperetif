package com.project.Aperetif.Model.enums;

public enum  PositionWorker {
    WINEMAKER_JUNIOR("Winemaker Junior",1),WINEMAKER_SENIOR("Senior Winemaker",2),WINE_CRITIC("Wine Critic",3);
    private String name;
    private int indexForDb;

    PositionWorker(String name,int indexForDb) {
        this.indexForDb = indexForDb;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getIndexForDb(){
        return indexForDb;
    }

    public static PositionWorker findByIndex(int indexForDb){
        switch (indexForDb){
            case 1:
                return PositionWorker.WINEMAKER_JUNIOR;
            case 2:
                return PositionWorker.WINEMAKER_SENIOR;
            case 3:
                return PositionWorker.WINE_CRITIC;
            default:
                return PositionWorker.WINEMAKER_JUNIOR;
        }
    }
}
