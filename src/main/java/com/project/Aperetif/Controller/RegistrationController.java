package com.project.Aperetif.Controller;

import com.project.Aperetif.Model.Users;
import com.project.Aperetif.Model.enums.Role;
import com.project.Aperetif.Services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String addUser(){
        return "registrationPage";
    }


    @PostMapping("/registration")
    public String addUser(@RequestParam("username") String username,
                          @RequestParam("email")String email,
                          @RequestParam("password")String password,
                          @RequestParam("passwordConfirm")String confirm,
                          Model model
    ){

        if(userService.saveUser(new Users(username,email,password,Role.USER),confirm)==1){
             return "redirect:/login";
        }else{
            model.addAttribute("message","Something was wrong");
            return "redirect:/registration";
        }

    }
}
