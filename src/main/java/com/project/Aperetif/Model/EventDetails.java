package com.project.Aperetif.Model;

import com.project.Aperetif.Model.enums.CategoryEvent;

import java.util.Objects;
import java.util.Set;


public class EventDetails {


    private Long id;

    private String DateStart;

    private String TimeStart;

    private Integer CostEvent;

    private Set<CategoryEvent> categoryEvents;


    public EventDetails(Long id,String dateStart, String timeStart,
                        Integer costEvent, Set<CategoryEvent> categoryEvents) {
        DateStart = dateStart;
        TimeStart = timeStart;
        CostEvent = costEvent;
        this.categoryEvents = categoryEvents;
        this.id = id;
    }

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


    @Override
    public String toString() {
        return "EventDetails{" +
                "id=" + id +
                ", DateStart='" + DateStart + '\'' +
                ", TimeStart='" + TimeStart + '\'' +
                ", CostEvent=" + CostEvent +
                ", categoryEvents=" + categoryEvents +
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
                Objects.equals(categoryEvents, that.categoryEvents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, DateStart, TimeStart,
                CostEvent, categoryEvents);
    }
}
