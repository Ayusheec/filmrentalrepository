package com.filmrentalstore.model;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "film_category")
public class FilmCategory {
	@EmbeddedId
    private FilmCategoryId id;

    @ManyToOne
    @MapsId("film_id")
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne
    @MapsId("category_id")
    @JoinColumn(name = "category_id")
    private Category category;

    private LocalDateTime last_update;

}