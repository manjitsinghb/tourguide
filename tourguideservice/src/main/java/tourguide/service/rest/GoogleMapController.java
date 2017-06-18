package tourguide.service.rest;

import com.google.maps.errors.ApiException;
import com.google.maps.model.*;
import org.springframework.web.bind.annotation.RequestParam;
import tourguide.service.converter.GeoCodingResultToMatchAddressConverter;
import com.tourguide.domain.MatchAddress;
import com.tourguide.googlemaps.GoogleMapAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by manjtsingh on 5/13/2017.
 */
@RestController
@EnableAutoConfiguration
public class GoogleMapController {

    @Autowired
    GoogleMapAdapter googleMapAdapter;

    @Autowired
    GeoCodingResultToMatchAddressConverter geoCodingResultToMatchAddressConverter;

    @RequestMapping(value = "/routeAddress", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> routeAddress(@RequestParam String startAddress, @RequestParam String destinationAddress) {
        try {
            startAddress = URLDecoder.decode(startAddress, Charset.forName("UTF-8").name());
            destinationAddress = URLDecoder.decode(destinationAddress,Charset.forName("UTF-8").name());
            DirectionsResult directionsResult = googleMapAdapter.getDirections(startAddress, destinationAddress);
            DirectionsRoute directionsRoute = directionsResult.routes[0];
            DirectionsLeg directionsLeg = directionsRoute.legs[0];
            DirectionsStep[] directionsStep = directionsLeg.steps;
            return Arrays.stream(directionsStep).map(e -> e.htmlInstructions).map(e -> e.replaceAll("\\<.*?\\>", "")).collect(Collectors.toList());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    @RequestMapping(value="/matchAddress", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<MatchAddress> getMatchingAddress(@RequestParam String inputAddress) {
        List<AutocompletePrediction> directionsResult = null;
        try {
            directionsResult = googleMapAdapter.getMatchingAddress(inputAddress);
            return geoCodingResultToMatchAddressConverter.convertToMatchAddressList(directionsResult);
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
