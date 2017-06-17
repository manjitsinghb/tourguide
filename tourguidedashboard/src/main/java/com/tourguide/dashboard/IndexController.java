package com.tourguide.dashboard;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by manjtsingh on 6/13/2017.
 */
@Component
public class IndexController {

    @RequestMapping("/index")
    public String index(Map<String, Object> model){
        return "index";
    }
}
