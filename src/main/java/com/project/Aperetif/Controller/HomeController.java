package com.project.Aperetif.Controller;

import com.project.Aperetif.Services.interfaces.EventService;
import com.project.Aperetif.Services.interfaces.WineService;
import com.project.Aperetif.Services.interfaces.WorkersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.stream.Collectors;

@Controller
public class HomeController {

    @Autowired
    private WorkersService workersService;

    @Autowired
    private EventService eventService;

    @Autowired
    private WineService wineService;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("AllWorkers",workersService.findAllWorker().stream().limit(4));
        model.addAttribute("Events",eventService.findAll());
        model.addAttribute("Wine",wineService.findAll().stream().limit(5).collect(Collectors.toList()));

        return "homePage";
    }
}
