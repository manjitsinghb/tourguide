package com.tourguide.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by manjtsingh on 6/13/2017.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public ModelAndView index(ModelAndView model){
        model.setViewName("views/index");
        return model;
    }

    @RequestMapping("/about")
    public ModelAndView about(ModelAndView model) {
        model.setViewName("views/about");
        return model;
    }
}
