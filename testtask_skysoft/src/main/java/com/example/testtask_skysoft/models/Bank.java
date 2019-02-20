package com.example.testtask_skysoft.models;

public class Bank {

    private String type;
    private String cityRU;
    private String cityUA;
    private String cityEN;
    private String fullAddressRu;
    private String fullAddressUa;
    private String fullAddressEn;
    private String placeRu;
    private String placeUa;
    private double latitude;
    private double longitude;
    private TimeWork tw;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCityRU() {
        return cityRU;
    }

    public void setCityRU(String cityRU) {
        this.cityRU = cityRU;
    }

    public String getCityUA() {
        return cityUA;
    }

    public void setCityUA(String cityUA) {
        this.cityUA = cityUA;
    }

    public String getCityEN() {
        return cityEN;
    }

    public void setCityEN(String cityEN) {
        this.cityEN = cityEN;
    }

    public String getFullAddressRu() {
        return fullAddressRu;
    }

    public void setFullAddressRu(String fullAddressRu) {
        this.fullAddressRu = fullAddressRu;
    }

    public String getFullAddressUa() {
        return fullAddressUa;
    }

    public void setFullAddressUa(String fullAddressUa) {
        this.fullAddressUa = fullAddressUa;
    }

    public String getFullAddressEn() {
        return fullAddressEn;
    }

    public void setFullAddressEn(String fullAddressEn) {
        this.fullAddressEn = fullAddressEn;
    }

    public String getPlaceRu() {
        return placeRu;
    }

    public void setPlaceRu(String placeRu) {
        this.placeRu = placeRu;
    }

    public String getPlaceUa() {
        return placeUa;
    }

    public void setPlaceUa(String placeUa) {
        this.placeUa = placeUa;
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

    public TimeWork getTw() {
        return tw;
    }

    public void setTw(TimeWork tw) {
        this.tw = tw;
    }
}