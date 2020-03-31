package com.project.Aperetif.Controller;

import com.project.Aperetif.Model.Wine;
import com.project.Aperetif.Services.interfaces.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    private final UserService userService;

    private final WineService wineService;

    private final EventService eventService;

    private final EventDetailsService eventDetailsService;

    private final EventsVenueService eventsVenueService;

    private final FavoriteWineService favoriteWineService;

    private final FeedBackService feedBackService;

    private final OrderService orderService;

    private final CheckoutOrderService checkoutOrderService;

    private final WorkersService workersService;

    public AdminController(UserService userService, WineService wineService,
                           EventService eventService, EventDetailsService eventDetailsService,
                           EventsVenueService eventsVenueService, FavoriteWineService favoriteWineService,
                           FeedBackService feedBackService, OrderService orderService, CheckoutOrderService
                                   checkoutOrderService, WorkersService workersService) {
        this.userService = userService;
        this.wineService = wineService;
        this.eventService = eventService;
        this.eventDetailsService = eventDetailsService;
        this.eventsVenueService = eventsVenueService;
        this.favoriteWineService = favoriteWineService;
        this.feedBackService = feedBackService;
        this.orderService = orderService;
        this.checkoutOrderService = checkoutOrderService;
        this.workersService = workersService;
    }

    @GetMapping("/adminPage")
    public String adminPage(Model model){
        model.addAttribute("UserList",userService.findAll());
        model.addAttribute("WineLIst",wineService.findAll());
        model.addAttribute("EventsList",eventService.findAll());
        model.addAttribute("EventVenueService",eventsVenueService);
        model.addAttribute("EventDetailsService",eventDetailsService);
        model.addAttribute("FavoriteWineService",favoriteWineService.findAll());
        model.addAttribute("FeedbackList",feedBackService.findAll());
        model.addAttribute("OrderList",orderService.FindAll());
        model.addAttribute("CheckoutOrderList",checkoutOrderService.findAllCheckoutOrders());
        model.addAttribute("WorkersList",workersService.findAllWorker());
        return "adminPage";
    }

    @GetMapping("/adminPage/addWine")
    public String addWine(){
        return "addWinePage";
    }

    @PostMapping("/adminPage/addWine")
    public String addWine(@RequestParam(name = "nameWine")String nameWine,
                          @RequestParam(name = "rating")String rating,
                          @RequestParam(name = "typeWines")String typeWines,
                          @RequestParam(name = "describe")String describe,
                          @RequestParam(name = "quantity")String quantity,
                          @RequestParam(name = "price")String price
                          ) {
        Wine wine = new Wine(nameWine,Integer.valueOf(rating),1,describe,Integer.valueOf(quantity),"","",Integer.valueOf(price));
        wineService.saveWine(wine);
        return "redirect:/adminPage";
    }

    @GetMapping("/adminPage/addEvent")
    public String addEvent(){
        return "addEventPage";
    }

    @GetMapping("/adminPage/addEventVenue")
    public String addEventVenue(){
        return "addEventVenuePage";
    }

    @GetMapping("/adminPage/addEventDetails")
    public String addDetailsVenue(){
        return "addEventDetailsPage";
    }

    @GetMapping("/adminPage/addWorker")
    public String addWorker(){
        return "addWorkerPage";
    }

    @GetMapping("/adminPage/DeleteWineById/{idWine}")
    public String deleteWine(@PathVariable("idWine")String idWine){
        return "redirect:/adminPage";
    }

    @GetMapping("/adminPage/DeleteUserById/{idUser}")
    public String deleteUser(@PathVariable("idUser")String idUser){
        return "redirect:/adminPage";
    }

    @GetMapping("/adminPage/DeleteEventById/{idEvent}")
    public String deleteEvent(@PathVariable("idEvent")String idEvent){
        return "redirect:/adminPage";
    }

    @GetMapping("/adminPage/DeleteWorkerById/{idWorker}")
    public String deleteWorker(@PathVariable("idWorker")String idWorker){
        return "redirect:/adminPage";
    }

    @GetMapping("/adminPage/EditWineById/{idWine}")
    public String editWine(@PathVariable("idWine")String idWine){
        return "editWinePage";
    }

 }
