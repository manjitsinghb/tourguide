package tourguide.service.rest;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by manjtsingh on 5/13/2017.
 */
@RestController
@EnableAutoConfiguration
public class IndexController {

    @RequestMapping(value = "/index",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String index() {
        return "hello";
    }
}
