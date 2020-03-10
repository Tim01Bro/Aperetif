package com.project.Aperetif.Model;

public enum  Role {
    ADMIN(1),USER(2);

    private int indexForDb;

    Role(int indexForDb){
        this.indexForDb = indexForDb;
    }

    public int getIndexForDb(){
        return this.indexForDb;
    }

    public static Role findByIndex(int index){
        return index == 1 ? Role.ADMIN : Role.USER;
    }
}
