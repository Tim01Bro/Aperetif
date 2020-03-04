package com.project.Aperetif.Model;

import javax.persistence.*;

@Entity
@Table(name = "Events")
public class Events {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nameEvent;

    private String DescribeEvent;

    @OneToOne(cascade = CascadeType.ALL)
    private EventDetails eventDetails;

    @OneToOne(cascade = CascadeType.ALL)
    private EventsVenue eventsVenue;
}
