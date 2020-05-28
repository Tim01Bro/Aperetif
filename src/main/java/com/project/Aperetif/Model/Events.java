package com.project.Aperetif.Model;


import java.util.Objects;

public class Events {

    private Long id;

    private String nameEvent;

    private String DescribeEvent;

    private Integer eventDetailsId;

    private Integer eventsVenueId;

    private EventsVenue eventsVenue;

    private EventDetails eventDetails;

    public Events(Long id, String nameEvent, String describeEvent, Integer eventDetailsId, Integer eventsVenueId) {
        this.id = id;
        this.nameEvent = nameEvent;
        DescribeEvent = describeEvent;
        this.eventDetailsId = eventDetailsId;
        this.eventsVenueId = eventsVenueId;
    }
    public Events(String nameEvent, String describeEvent, Integer eventDetailsId, Integer eventsVenueId) {

        this.nameEvent = nameEvent;
        DescribeEvent = describeEvent;
        this.eventDetailsId = eventDetailsId;
        this.eventsVenueId = eventsVenueId;
    }

    public Events() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameEvent() {
        return nameEvent;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public String getDescribeEvent() {
        return DescribeEvent;
    }

    public void setDescribeEvent(String describeEvent) {
        DescribeEvent = describeEvent;
    }

    public Integer getEventDetailsId() {
        return eventDetailsId;
    }

    public void setEventDetailsId(Integer eventDetailsId) {
        this.eventDetailsId = eventDetailsId;
    }

    public Integer getEventsVenueId() {
        return eventsVenueId;
    }

    public void setEventsVenueId(Integer eventsVenueId) {
        this.eventsVenueId = eventsVenueId;
    }

    public EventsVenue getEventsVenue() {
        return eventsVenue;
    }

    public void setEventsVenue(EventsVenue eventsVenue) {
        this.eventsVenue = eventsVenue;
    }

    public EventDetails getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(EventDetails eventDetails) {
        this.eventDetails = eventDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Events events = (Events) o;
        return Objects.equals(id, events.id) &&
                Objects.equals(nameEvent, events.nameEvent) &&
                Objects.equals(DescribeEvent, events.DescribeEvent) &&
                Objects.equals(eventDetailsId, events.eventDetailsId) &&
                Objects.equals(eventsVenueId, events.eventsVenueId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameEvent, DescribeEvent, eventDetailsId, eventsVenueId);
    }

    @Override
    public String toString() {
        return "Events{" +
                "id=" + id +
                ", nameEvent='" + nameEvent + '\'' +
                ", DescribeEvent='" + DescribeEvent + '\'' +
                ", eventDetailsId=" + eventDetailsId +
                ", eventsVenueId=" + eventsVenueId +
                '}';
    }
}
