package com.filmrentalstore.dto;
import java.time.LocalDateTime;
import java.util.List;
public class CountryDTO {
    private int countryId;
    private String country;
    private LocalDateTime lastUpdate;
    private List<Integer> cityIds; // Representing cities by their IDs
    public int getCountryId() {
        return countryId;
    }
    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }
    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    public List<Integer> getCityIds() {
        return cityIds;
    }
    public void setCityIds(List<Integer> cityIds) {
        this.cityIds = cityIds;
    }
    @Override
    public String toString() {
        return "CountryDTO{" +
                "countryId=" + countryId +
                ", country='" + country + '\'' +
                ", lastUpdate=" + lastUpdate +
                ", cityIds=" + cityIds +
                '}';
    }
}