package com.exposition.backend;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "game_name", nullable = false, length = 50)
    private String name;

    @Column(name = "game_price", columnDefinition = "NUMERIC(4, 2) CHECK(game_price >= 100)")
    private BigDecimal price = new BigDecimal(100.00);

    @Column(name = "game_rating", columnDefinition = "SET DEFAULT 0")
    private int rating = 0;

    @Column(name = "game_publisher")
    private String publisher;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String _name) {
        name = _name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal _price) {
        price = _price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int _rating) {
        rating = _rating;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String _publisher) {
        publisher = _publisher;
    }

}
