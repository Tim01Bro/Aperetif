package com.project.Aperetif.Model;

import com.project.Aperetif.Model.enums.PositionWorker;

import java.util.Objects;
import java.util.Set;


public class Workers {

    private Long id;
    private String nameWorker;
    private String sonameWorker;
    private String filename;
    private String describe;


    private Set<PositionWorker> positionWorkers;

    private String linkFacebook;

    private String linkTwitter;

    private String lingLinkedIN;

    public Workers(Long id,String nameWorker, String sonameWorker, String filename, String describe,
                   Set<PositionWorker> positionWorkers, String linkFacebook, String linkTwitter, String lingLinkedIN) {
        this.nameWorker = nameWorker;
        this.sonameWorker = sonameWorker;
        this.filename = filename;
        this.describe = describe;
        this.positionWorkers = positionWorkers;
        this.linkFacebook = linkFacebook;
        this.linkTwitter = linkTwitter;
        this.lingLinkedIN = lingLinkedIN;
        this.id = id;
    }

    public Workers() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameWorker() {
        return nameWorker;
    }

    public void setNameWorker(String nameWorker) {
        this.nameWorker = nameWorker;
    }

    public String getSonameWorker() {
        return sonameWorker;
    }

    public void setSonameWorker(String sonameWorker) {
        this.sonameWorker = sonameWorker;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Set<PositionWorker> getPositionWorkers() {
        return positionWorkers;
    }

    public void setPositionWorkers(Set<PositionWorker> positionWorkers) {
        this.positionWorkers = positionWorkers;
    }

    public String getLinkFacebook() {
        return linkFacebook;
    }

    public void setLinkFacebook(String linkFacebook) {
        this.linkFacebook = linkFacebook;
    }

    public String getLinkTwitter() {
        return linkTwitter;
    }

    public void setLinkTwitter(String linkTwitter) {
        this.linkTwitter = linkTwitter;
    }

    public String getLingLinkedIN() {
        return lingLinkedIN;
    }

    public void setLingLinkedIN(String lingLinkedIN) {
        this.lingLinkedIN = lingLinkedIN;
    }

    @Override
    public String toString() {
        return "Workers{" +
                "id=" + id +
                ", nameWorker='" + nameWorker + '\'' +
                ", sonameWorker='" + sonameWorker + '\'' +
                ", filename='" + filename + '\'' +
                ", describe='" + describe + '\'' +
                ", positionWorkers=" + positionWorkers +
                ", linkFacebook='" + linkFacebook + '\'' +
                ", linkTwitter='" + linkTwitter + '\'' +
                ", lingLinkedIN='" + lingLinkedIN + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Workers workers = (Workers) o;
        return Objects.equals(id, workers.id) &&
                Objects.equals(nameWorker, workers.nameWorker) &&
                Objects.equals(sonameWorker, workers.sonameWorker) &&
                Objects.equals(filename, workers.filename) &&
                Objects.equals(describe, workers.describe) &&
                Objects.equals(positionWorkers, workers.positionWorkers) &&
                Objects.equals(linkFacebook, workers.linkFacebook) &&
                Objects.equals(linkTwitter, workers.linkTwitter) &&
                Objects.equals(lingLinkedIN, workers.lingLinkedIN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameWorker, sonameWorker, filename, describe, positionWorkers, linkFacebook, linkTwitter, lingLinkedIN);
    }
}
