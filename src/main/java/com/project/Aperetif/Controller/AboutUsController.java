package com.project.Aperetif.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutUsController {

    @GetMapping("/aboutus")
    public String aboutUsPage(){
        return "aboutusPage";
    }

    @GetMapping("/outstory")
    public String OutStory(){
        return "outstoryPage";
    }
}
