package com.project.Aperetif.Controller;

import com.project.Aperetif.Model.Orders;
import com.project.Aperetif.Services.interfaces.FavoriteWineService;
import com.project.Aperetif.Services.interfaces.OrderService;
import com.project.Aperetif.Services.interfaces.UserService;
import com.project.Aperetif.Services.interfaces.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;

@Controller
public class FavoriteWineController {

    @Autowired
    private FavoriteWineService favoriteWineService;

    @Autowired
    private UserService userService;

    @Autowired
    private WineService wineService;

    @Autowired
    private OrderService orderService;


    @GetMapping("/favoriteWine")
    public String favoriteAll(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("FavWines",favoriteWineService.findAllByUserId(userService.getUserByName(auth.getName()).getId()));
        model.addAttribute("WineService",wineService);
        return "favoritewinePage";
    }

    @GetMapping("/deleteFavoriteWine/{idWine}")
    public String deleteFavorite(@PathVariable("idWine")String idWine){
        favoriteWineService.deleteFavoriteWineById(Long.valueOf(idWine));
        return "redirect:/favoriteWine";
    }

    @GetMapping("/AddToCart/{idWine}")
    public String addToCart(@PathVariable("idWine")String idWine){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        orderService.saveOrder(new Orders(userService.getUserByName(auth.getName()).getId(),Integer.valueOf(idWine),LocalDate.now().toString()));
        favoriteWineService.deleteFavoriteWineById(Long.valueOf(idWine));
        return "redirect:/favoriteWine";
    }

}
