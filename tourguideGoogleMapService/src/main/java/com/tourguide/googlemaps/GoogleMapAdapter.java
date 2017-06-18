package com.tourguide.googlemaps;

import com.google.maps.*;
import com.google.maps.errors.ApiException;
import com.google.maps.model.AutocompletePrediction;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.GeocodingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by manjtsingh on 6/13/2017.
 */
@Component
public class GoogleMapAdapter {

  @Autowired
  GeoApiContext geoApiContext;

public DirectionsResult getDirections(String origin, String destination) throws InterruptedException, ApiException, IOException {
    DirectionsApiRequest directionsApiRequest = DirectionsApi.getDirections(geoApiContext,origin,destination);
    DirectionsResult directionsResult = directionsApiRequest.await();
    return directionsResult;
}

public List<AutocompletePrediction> getMatchingAddress(String inputAddress) throws InterruptedException, ApiException, IOException {
    AutocompletePrediction[] autocompletePredictions = PlacesApi.placeAutocomplete(geoApiContext,inputAddress).await();
    return Arrays.asList(autocompletePredictions);
}
}
