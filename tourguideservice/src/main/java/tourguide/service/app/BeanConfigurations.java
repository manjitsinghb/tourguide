package tourguide.service.app;

import com.google.maps.GeoApiContext;
import org.springframework.beans.factory.annotation.Value;
import tourguide.service.converter.GeoCodingResultToMatchAddressConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by manjtsingh on 6/17/2017.
 */
@Component
public class BeanConfigurations {

    @Value("${google.api.key}")
    private String googleApiKey;

    @Bean
    public GeoCodingResultToMatchAddressConverter geoCodingResultToMatchAddressConverter() {
        return new GeoCodingResultToMatchAddressConverter();
    }

    @Bean
    public GeoApiContext geoApiContext() {
        GeoApiContext geoApiContext = new GeoApiContext();
        geoApiContext.setApiKey(googleApiKey);
        return geoApiContext;
    }
}
