package com.filmrentalstore.model;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.*;

@Entity
@Table(name = "city")
public class City {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int city_id;

    private String city;

    @ManyToOne
    @JoinColumn(name = "country_id")
    @JsonIgnore
    private Country country;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime last_update;

    @OneToMany(mappedBy = "city")
    @JsonIgnore
    private List<Address> addresses=new ArrayList<>();

	public int getCity_id() {
		return city_id;
	}

	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public LocalDateTime getLast_update() {
		return last_update;
	}

	public void setLast_update(LocalDateTime last_update) {
		this.last_update = last_update;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "City [city_id=" + city_id + ", city=" + city + ", country=" + country + ", last_update=" + last_update
				+ ", addresses=" + addresses + ", getCity_id()=" + getCity_id() + ", getCity()=" + getCity()
				+ ", getCountry()=" + getCountry() + ", getLast_update()=" + getLast_update() + ", getAddresses()="
				+ getAddresses() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

    
}
