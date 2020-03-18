package com.project.Aperetif.Model;

 import java.util.Objects;


public class EventsVenue {

    private Long id;

    private String PlaceEvent;

    private String AddressEvent;

    private String webSiteEvent;

    private String phoneEvent;

    public EventsVenue(Long id,String placeEvent, String addressEvent,
                       String webSiteEvent, String phoneEvent) {
        PlaceEvent = placeEvent;
        AddressEvent = addressEvent;
        this.webSiteEvent = webSiteEvent;
        this.phoneEvent = phoneEvent;
        this.id = id;
    }


    public EventsVenue(String placeEvent, String addressEvent,
                       String webSiteEvent, String phoneEvent) {
        PlaceEvent = placeEvent;
        AddressEvent = addressEvent;
        this.webSiteEvent = webSiteEvent;
        this.phoneEvent = phoneEvent;
    }

    public EventsVenue() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaceEvent() {
        return PlaceEvent;
    }

    public void setPlaceEvent(String placeEvent) {
        PlaceEvent = placeEvent;
    }

    public String getAddressEvent() {
        return AddressEvent;
    }

    public void setAddressEvent(String addressEvent) {
        AddressEvent = addressEvent;
    }

    public String getWebSiteEvent() {
        return webSiteEvent;
    }

    public void setWebSiteEvent(String webSiteEvent) {
        this.webSiteEvent = webSiteEvent;
    }

    public String getPhoneEvent() {
        return phoneEvent;
    }

    public void setPhoneEvent(String phoneEvent) {
        this.phoneEvent = phoneEvent;
    }



    @Override
    public String toString() {
        return "EventsVenue{" +
                "id=" + id +
                ", PlaceEvent='" + PlaceEvent + '\'' +
                ", AddressEvent='" + AddressEvent + '\'' +
                ", webSiteEvent='" + webSiteEvent + '\'' +
                ", phoneEvent='" + phoneEvent + '\''+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventsVenue that = (EventsVenue) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(PlaceEvent, that.PlaceEvent) &&
                Objects.equals(AddressEvent, that.AddressEvent) &&
                Objects.equals(webSiteEvent, that.webSiteEvent) &&
                Objects.equals(phoneEvent, that.phoneEvent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, PlaceEvent, AddressEvent, webSiteEvent, phoneEvent);
    }
}
