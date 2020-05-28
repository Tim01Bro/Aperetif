package com.project.Aperetif.Controller;

import com.project.Aperetif.Model.CheckoutOrder;
import com.project.Aperetif.Services.interfaces.CheckoutOrderService;
import com.project.Aperetif.Services.interfaces.OrderService;
import com.project.Aperetif.Services.interfaces.UserService;
import com.project.Aperetif.Services.interfaces.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private WineService wineService;

    @Autowired
    private CheckoutOrderService checkoutOrderService;

    @GetMapping("/orders")
    public String getAllOrdersByUser(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("ordersUser",orderService.FindAllByUserId(userService.getUserByName(auth.getName()).getId()));
        model.addAttribute("wineService",wineService);
        model.addAttribute("userId", userService.getUserByName(auth.getName()).getId());
         return "ordersPage";
    }

    @PostMapping("/CalcFinalPrice")
    public String CalcFinalPrice(@RequestParam(name = "quantity")String quantity,Model model
            ,@RequestParam(name = "wineId")String wineid){
        model.addAttribute("qt",Integer.valueOf(quantity) * wineService.getWineById(Long.valueOf(wineid)).getPrice());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("ordersUser",orderService.FindAllByUserId(userService.getUserByName(auth.getName()).getId()));
        model.addAttribute("wineService",wineService);

        return "ordersPage";
    }

    @GetMapping("/orders/delete/{idOrder}")
    public String deleteOrdersById(@PathVariable("idOrder")String idOrder){
        orderService.deleteOrder(Long.valueOf(idOrder));
        return "redirect:/AP_Main/orders";
    }

    @GetMapping("/checkoutorder/{Userid}")
    public String checkoutOrders(@PathVariable("Userid")String userId,
        Model model

    ){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("wineService",wineService);
        model.addAttribute("ordersUser",orderService.FindAllByUserId(Long.valueOf(userId)));
        model.addAttribute("userId", userService.getUserByName(auth.getName()).getId());

        return "checkoutOrderPage";
    }

    @PostMapping("/checkoutorder/check/{userId}")
    public String checkOrder(@ModelAttribute("CheckoutOrder")CheckoutOrder checkoutOrder,
    @PathVariable("userId")String userId){

        checkoutOrderService.SaveCheckoutOrder(checkoutOrder);
        orderService.deleteAllByUserId(Long.valueOf(userId));
        return "redirect:/orders";
    }


}
