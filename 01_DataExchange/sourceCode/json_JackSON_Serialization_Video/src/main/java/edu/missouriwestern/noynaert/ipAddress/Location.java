package edu.missouriwestern.noynaert.ipAddress;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;


public class Location {
    @JsonAlias({"ip"})
    private String ipAddress;
    @JsonAlias({"country_code"})
    private String countryCode;
    @JsonAlias({"lat"})
    private double latitude;
    @JsonAlias({"lon","long"})
    private double longitude;
    @JsonAlias({"cacheTimestamp"})
    private LocalDateTime timeStamp;
    private static ObjectMapper locationMapper = Location.getLocationMapper();

    public Location(String ipAddress, String countryCode, double latitude, double longitude, LocalDateTime timeStamp) {
        setIpAddress(ipAddress);
        setCountryCode(countryCode);
        setLatitude(latitude);
        setLongitude(longitude);
        setTimeStamp(timeStamp);
    }
    public Location(){
        this("---.---.---.---","--",0.000,0.000, null );
    }
    private static ObjectMapper getLocationMapper(){
        if(locationMapper==null){
            locationMapper = new ObjectMapper();
            // configure and customize to handle Location objects

            //Handle LocalDates
            locationMapper.registerModule(new JavaTimeModule());
            locationMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);

            // configure to handle missing fields
            locationMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            locationMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false)
        }
        return locationMapper;
    }
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return
                "ipAddress='" + ipAddress + '\'' +
                        ", countryCode='" + countryCode + '\'' +
                        ", latitude=" + latitude +
                        ", longitude=" + longitude +
                        ", timeStamp=" + timeStamp;
    }

    public String toJson() throws JsonProcessingException {

            return locationMapper.writeValueAsString(this);


    }
    public static Location fromJson(String jsonString) throws JsonProcessingException {
            Location location = locationMapper.readValue(jsonString, Location.class);
            return location;
    }

}
