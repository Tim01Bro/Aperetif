package com.project.Aperetif.Model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "EventDetails")
public class EventDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String DateStart;

    private String TimeStart;

    private Integer CostEvent;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name="category_event",joinColumns = @JoinColumn(name = "eventDetails_id"))
    @Enumerated(EnumType.STRING)
    private Set<CategoryEvent> categoryEvents;

    @OneToOne(mappedBy = "eventDetails")
    private Events events;

    public EventDetails(Long id,String dateStart, String timeStart,
                        Integer costEvent, Set<CategoryEvent> categoryEvents, Events events) {
        DateStart = dateStart;
        TimeStart = timeStart;
        CostEvent = costEvent;
        this.categoryEvents = categoryEvents;
        this.events = events;
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

    public Events getEvents() {
        return events;
    }

    public void setEvents(Events events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "EventDetails{" +
                "id=" + id +
                ", DateStart='" + DateStart + '\'' +
                ", TimeStart='" + TimeStart + '\'' +
                ", CostEvent=" + CostEvent +
                ", categoryEvents=" + categoryEvents +
                ", events=" + events +
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
                Objects.equals(events, that.events);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, DateStart, TimeStart,
                CostEvent, categoryEvents, events);
    }
}
