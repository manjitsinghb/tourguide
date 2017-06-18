package com.tourguide.domain;

/**
 * Created by manjtsingh on 6/17/2017.
 */
public class MatchAddress {

    public String matchedAddress;
    public String latitude;
    public String longitude;

    public String getMatchedAddress() {
        return matchedAddress;
    }

    public void setMatchedAddress(String matchedAddress) {
        this.matchedAddress = matchedAddress;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
