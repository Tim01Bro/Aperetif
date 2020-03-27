package com.project.Aperetif.Controller;

import com.project.Aperetif.Model.FavoriteWIne;
import com.project.Aperetif.Model.Orders;
import com.project.Aperetif.Model.enums.TypeWine;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
public class ShopController {

    @Autowired
    private WineService wineService;

    @Autowired
    private FavoriteWineService favoriteWineService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/shoplist")
    public String shopList(Model model){
        model.addAttribute("Wines",wineService.findAll());
        model.addAttribute("TypeWine", TypeWine.values());
        return "shopPage";
    }

    @PostMapping("/filter")
    public String findWineByName(@RequestParam(name = "filter")String filter,
        Model model
    ){
      if(!filter.equals("")){
          model.addAttribute("Wines",wineService.getWineByName(filter));
          model.addAttribute("TypeWine", TypeWine.values());

      }else{
          model.addAttribute("Wines",wineService.findAll());
          model.addAttribute("TypeWine", TypeWine.values());

      }
    return "shopPage";
    }


   @GetMapping("/getAllWineByType/{type}")
   public String getAllWineByType(@PathVariable("type")String type,Model model){
        if(!type.equals("")){
            model.addAttribute("Wines",wineService.findByType(TypeWine.getTypeByName(type)));
            model.addAttribute("TypeWine", TypeWine.values());
        }
        return "shopPage";
   }

    @GetMapping("/addtoFavorite/{id}")
    public String addToFavorite(@PathVariable("id")String wineId){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        favoriteWineService.saveFavoriteWine(new FavoriteWIne(Long.valueOf(wineId),
                userService.getUserByName(auth.getName()).getId(),
                LocalDateTime.now().toString()));


        return "redirect:/shoplist";

    }

    @GetMapping("/GetCurrentWine/{id}")
    public String MoreInfo(@PathVariable("id")String wineId,Model model){
        model.addAttribute("Wine",wineService.getWineById(Long.valueOf(wineId)));
        return "CurrentWinePage";
    }

    @GetMapping("/addToOrder/{id}")
    public String addToOrder(@PathVariable("id")String wineId){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        orderService.saveOrder(new Orders( userService.getUserByName(auth.getName()).getId(),Integer.valueOf(wineId), LocalDate.now().toString()));

        return "redirect:/shoplist";
    }

    @PostMapping("/getAllByPrice")
    public String getAllByPrice(@RequestParam(name = "rangePrice")String rangePrice,Model model){
        if(!rangePrice.equals("")){
            model.addAttribute("Wines",wineService.findByLimitPrice(1,Integer.valueOf(rangePrice)));
            model.addAttribute("TypeWine", TypeWine.values());
            System.out.println("SIZE"+ wineService.findByLimitPrice(1,Integer.valueOf(rangePrice)).size());
        }
        return "redirect:/shoplist";
    }




}
