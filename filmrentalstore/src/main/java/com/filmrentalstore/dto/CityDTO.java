package com.filmrentalstore.dto;
import java.time.LocalDateTime;
import java.util.List;
public class CityDTO {
    private int cityId;
    private String city;
    private int countryId; // Representing the Country by its ID
    private LocalDateTime lastUpdate;
    private List<Long> addressIds; // Representing Addresses by their IDs
    public int getCityId() {
        return cityId;
    }
    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public int getCountryId() {
        return countryId;
    }
    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }
    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }
    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    public List<Long> getAddressIds() {
        return addressIds;
    }
    public void setAddressIds(List<Long> addressIds) {
        this.addressIds = addressIds;
    }
    @Override
    public String toString() {
        return "CityDTO{" +
                "cityId=" + cityId +
                ", city='" + city + '\'' +
                ", countryId=" + countryId +
                ", lastUpdate=" + lastUpdate +
                ", addressIds=" + addressIds +
                '}';
    }
}