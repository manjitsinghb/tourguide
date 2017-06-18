package com.tourguide.rest;

import com.tourguide.domain.MatchAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by manjtsingh on 6/16/2017.
 */
@RestController
public class TourGuideIndexRestController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/matchAddress",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MatchAddress> matchAddress(@RequestParam String searchAddress) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("inputAddress",searchAddress);
        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl("http://localhost/matchAddress").queryParams(params).build();
        List<MatchAddress> matchedAddress = restTemplate.getForObject(uriComponents.encode().toUri().toString()
                , List.class);
        return matchedAddress;
    }

    @RequestMapping(value = "/routeAddress", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<String> routeAddress(@RequestParam String startAddress, @RequestParam String destination) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("startAddress",startAddress);
        params.add("destinationAddress",destination);
        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl("http://localhost/routeAddress").queryParams(params).build();
        List<String> routeAddress = restTemplate.getForObject(uriComponents.encode().toUri().toString()
                , List.class);
        return routeAddress;
    }

}
