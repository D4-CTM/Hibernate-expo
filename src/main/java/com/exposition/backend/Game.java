package com.exposition.Objects;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "game_name", nullable = false)
    private String name;

    @Column(name = "game_price")
    private float price = 0.1f;

    @Column(name = "game_rating")
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float _price) {
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
