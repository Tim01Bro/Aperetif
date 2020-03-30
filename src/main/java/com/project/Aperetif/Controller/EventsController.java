package com.project.Aperetif.Controller;

import com.project.Aperetif.Services.interfaces.EventDetailsService;
import com.project.Aperetif.Services.interfaces.EventService;
import com.project.Aperetif.Services.interfaces.EventsVenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EventsController {

    @Autowired
    private EventsVenueService eventsVenueService;

    @Autowired
    private EventService eventService;

    @Autowired
    private EventDetailsService eventDetailsService;

    @GetMapping("/eventList")
    public String eventList(Model model){
        model.addAttribute("eventList",eventService.findAll());
        model.addAttribute("eventVenueService",eventsVenueService);
        model.addAttribute("eventDetailsService",eventDetailsService);
        return "eventlistPage";
    }

    @GetMapping("/eventList/{idEvent}")
    public String oneEvent(@PathVariable("idEvent")String idEvent, Model model){
        model.addAttribute(eventService.getEventById(Long.valueOf(idEvent)));
        return "eventone";
    }

    @PostMapping("/findEventByName")
    public String findByNameEvent(@RequestParam(name = "filter")String name,
                                  Model model){
        if(!name.equals("")) {
            model.addAttribute("eventList", eventService.getEventByName(name));
            model.addAttribute("eventVenueService",eventsVenueService);
            model.addAttribute("eventDetailsService",eventDetailsService);
        }else{
            model.addAttribute("eventList",eventService.findAll());
            model.addAttribute("eventVenueService",eventsVenueService);
            model.addAttribute("eventDetailsService",eventDetailsService);
        }

        return "eventlistPage";
    }

}
