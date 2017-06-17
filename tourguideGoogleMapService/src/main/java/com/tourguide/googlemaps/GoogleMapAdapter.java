package com.tourguide.googlemaps;

import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by manjtsingh on 6/13/2017.
 */
@Component
public class GoogleMapAdapter {

    @Value("${google.api.key}")
    private String googleApiKey;

public DirectionsResult getDirections(String origin, String destination) throws InterruptedException, ApiException, IOException {
    GeoApiContext geoApiContext = new GeoApiContext();
    geoApiContext.setApiKey(googleApiKey);
    DirectionsApiRequest directionsApiRequest = DirectionsApi.getDirections(geoApiContext,origin,destination);
    DirectionsResult directionsResult = directionsApiRequest.await();
    return directionsResult;
}
}
