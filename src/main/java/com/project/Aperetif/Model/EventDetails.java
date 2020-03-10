package com.project.Aperetif.Model;

import java.util.Objects;
import java.util.Set;


public class EventDetails {


    private Long id;

    private String DateStart;

    private String TimeStart;

    private Integer CostEvent;

    private Set<CategoryEvent> categoryEvents;

    private Integer eventsId;

    public EventDetails(Long id,String dateStart, String timeStart,
                        Integer costEvent, Set<CategoryEvent> categoryEvents, Integer eventsId) {
        DateStart = dateStart;
        TimeStart = timeStart;
        CostEvent = costEvent;
        this.categoryEvents = categoryEvents;
        this.eventsId = eventsId;
        this.id = id;
    }
   /* create table EventDetails(
            id serial primary key,
            DateStart varchar,
            TimeStart varchar,
            CostEvent int,
            categoryEvent varchar,
            EventsId int,
            FOREIGN KEY (categoryEvent) REFERENCES categoryevent(category)
            );*/

    public EventDetails() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateStart() {
        return DateStart;
    }

    public void setDateStart(String dateStart) {
        DateStart = dateStart;
    }

    public String getTimeStart() {
        return TimeStart;
    }

    public void setTimeStart(String timeStart) {
        TimeStart = timeStart;
    }

    public Integer getCostEvent() {
        return CostEvent;
    }

    public void setCostEvent(Integer costEvent) {
        CostEvent = costEvent;
    }

    public Set<CategoryEvent> getCategoryEvents() {
        return categoryEvents;
    }

    public void setCategoryEvents(Set<CategoryEvent> categoryEvents) {
        this.categoryEvents = categoryEvents;
    }

    public Integer getEvents() {
        return eventsId;
    }

    public void setEvents(Integer eventsId) {
        this.eventsId = eventsId;
    }

    @Override
    public String toString() {
        return "EventDetails{" +
                "id=" + id +
                ", DateStart='" + DateStart + '\'' +
                ", TimeStart='" + TimeStart + '\'' +
                ", CostEvent=" + CostEvent +
                ", categoryEvents=" + categoryEvents +
                ", eventsId=" + eventsId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventDetails that = (EventDetails) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(DateStart, that.DateStart) &&
                Objects.equals(TimeStart, that.TimeStart) &&
                Objects.equals(CostEvent, that.CostEvent) &&
                Objects.equals(categoryEvents, that.categoryEvents) &&
                Objects.equals(eventsId, that.eventsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, DateStart, TimeStart,
                CostEvent, categoryEvents, eventsId);
    }
}
