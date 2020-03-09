package com.project.Aperetif.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Venue")
public class EventsVenue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String PlaceEvent;

    private String AddressEvent;

    private String webSiteEvent;

    private String phoneEvent;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "eventsVenue")
    private Events events;

    public EventsVenue(Long id,String placeEvent, String addressEvent,
                       String webSiteEvent, String phoneEvent, Events events) {
        PlaceEvent = placeEvent;
        AddressEvent = addressEvent;
        this.webSiteEvent = webSiteEvent;
        this.phoneEvent = phoneEvent;
        this.events = events;
        this.id = id;
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

    public Events getEvents() {
        return events;
    }

    public void setEvents(Events events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "EventsVenue{" +
                "id=" + id +
                ", PlaceEvent='" + PlaceEvent + '\'' +
                ", AddressEvent='" + AddressEvent + '\'' +
                ", webSiteEvent='" + webSiteEvent + '\'' +
                ", phoneEvent='" + phoneEvent + '\'' +
                ", events=" + events +
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
                Objects.equals(phoneEvent, that.phoneEvent) &&
                Objects.equals(events, that.events);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, PlaceEvent, AddressEvent, webSiteEvent, phoneEvent, events);
    }
}
