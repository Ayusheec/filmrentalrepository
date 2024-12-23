package com.filmrentalstore;
import com.filmrentalstore.dao.CityImpl;
import com.filmrentalstore.model.City;
import com.filmrentalstore.model.Country;
import com.filmrentalstore.repository.CityRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CityServiceTest {

    @Mock
    private CityRepo cityRepo;

    @InjectMocks
    private CityImpl cityService;

    private City city;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Creating a mock City object
        city = new City();
        city.setCity_id(1);
        city.setCity("New York");
        city.setCountry(new Country()); // Assuming Country is set here
        city.setLast_update(LocalDateTime.now());
    }

    @Test
    public void testAddCity() {
        // Arrange: Mocking the repository save method
        when(cityRepo.save(any(City.class))).thenReturn(city);

        // Act: Call the service method
        City savedCity = cityService.addCity(city);

        // Assert: Verify the result
        assertEquals(city.getCity_id(), savedCity.getCity_id());
        assertEquals(city.getCity(), savedCity.getCity());
        verify(cityRepo, times(1)).save(city);
    }

    @Test
    public void testAddCityNullCheck() {
        // Arrange: Handle the case when the city is null
        when(cityRepo.save(null)).thenThrow(new IllegalArgumentException("City cannot be null"));

        try {
            cityService.addCity(null);
        } catch (IllegalArgumentException ex) {
            assertEquals("City cannot be null", ex.getMessage());
        }

        verify(cityRepo, times(0)).save(any());
    }
}
