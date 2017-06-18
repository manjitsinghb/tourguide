package tourguide.service.converter;

import com.google.maps.model.AutocompletePrediction;
import com.google.maps.model.DirectionsResult;
import com.tourguide.domain.MatchAddress;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by manjtsingh on 6/17/2017.
 */
public class GeoCodingResultToMatchAddressConverter {
    public List<MatchAddress> convertToMatchAddressList(List<AutocompletePrediction> autocompletePredictions) {
       return autocompletePredictions.stream().map(e -> convertToMatchAddress(e)).collect(Collectors.toList());
    }

    private MatchAddress convertToMatchAddress(AutocompletePrediction autocompletePrediction){
        MatchAddress matchAddress = new MatchAddress();
        matchAddress.setMatchedAddress(autocompletePrediction.description);
        return matchAddress;
    }
}
