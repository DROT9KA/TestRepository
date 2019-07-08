package ua.study.awesome.androidlessons.testtask_skysoft.ui.bank_list.data.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BankResponse {

    @Expose
    @SerializedName("type")
    private String type;
    @Expose
    @SerializedName("cityRU")
    private String cityRU;
    @Expose
    @SerializedName("cityUA")
    private String cityUA;
    @Expose
    @SerializedName("cityEN")
    private String cityEN;
    @Expose
    @SerializedName("fullAddressRu")
    private String fullAddressRu;
    @Expose
    @SerializedName("fullAddressUa")
    private String fullAddressUa;
    @Expose
    @SerializedName("fullAddressEn")
    private String fullAddressEn;
    @Expose
    @SerializedName("placeRu")
    private String placeRu;
    @Expose
    @SerializedName("placeUa")
    private String placeUa;
    @Expose
    @SerializedName("latitude")
    private double latitude;
    @Expose
    @SerializedName("longitude")
    private double longitude;
    @Expose
    @SerializedName("tw")
    private TimeWorkResponse tw;

    /*GETTERS & SETTERS*/

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

    public TimeWorkResponse getTw() {
        return tw;
    }

    public void setTw(TimeWorkResponse tw) {
        this.tw = tw;
    }
}