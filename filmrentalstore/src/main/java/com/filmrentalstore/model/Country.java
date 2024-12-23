package com.filmrentalstore.model;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@AllArgsConstructor
@NoArgsConstructor
 
@Entity
@Table(name = "country")
public class Country {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int country_id;

    private String country;

    private LocalDateTime last_update;

    @OneToMany(mappedBy = "country")
    private List<City> cities=new ArrayList<>();
}
