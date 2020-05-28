package com.project.Aperetif.Model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum  Role implements GrantedAuthority {
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

    @Override
    public String getAuthority() {
        return name();
    }
}
