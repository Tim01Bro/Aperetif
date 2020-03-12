package com.project.Aperetif.Model.enums;

public enum  CategoryEvent {
    WINE_TASTING("Wine tasting",1),WINE_TOUR("Wine tour",2);
    private String name;
    private int indexForDb;

    CategoryEvent(String name,int indexForDb) {
        this.name = name;
        this.indexForDb = indexForDb;
    }

    public String getName() {
        return name;
    }

    public int getIndexForDb(){
        return indexForDb;
    }

    public static CategoryEvent findByIndex(int indexForDb){
        return indexForDb == 1 ? CategoryEvent.WINE_TASTING : CategoryEvent.WINE_TOUR;
    }
}
