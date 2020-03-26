package com.project.Aperetif.Controller;

import com.project.Aperetif.Model.enums.TypeWine;
import com.project.Aperetif.Services.interfaces.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShopController {

    @Autowired
    private WineService wineService;

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
      }else{
          model.addAttribute("Wines",wineService.findAll());
      }
    return "shopPage";
    }




}
