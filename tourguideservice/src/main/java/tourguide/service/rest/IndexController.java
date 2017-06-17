package tourguide.service.rest;

import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.DirectionsStep;
import com.tourguide.googlemaps.GoogleMapAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by manjtsingh on 5/13/2017.
 */
@RestController
@EnableAutoConfiguration
public class IndexController {

    @Autowired
    GoogleMapAdapter googleMapAdapter;

    @RequestMapping(value = "/index", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<String> index() {
        try {
            DirectionsResult directionsResult = googleMapAdapter.getDirections("2800 Western Ave Seattle 98121", "Seatac airport");
            DirectionsRoute directionsRoute = directionsResult.routes[0];
            DirectionsLeg directionsLeg = directionsRoute.legs[0];
            DirectionsStep[] directionsStep = directionsLeg.steps;
            return Arrays.stream(directionsStep).map(e -> e.htmlInstructions).collect(Collectors.toList());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
}
