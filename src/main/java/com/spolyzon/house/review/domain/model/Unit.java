package com.spolyzon.house.review.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Unit implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private final String title;
    private final String region;
    private final int price; // Todo: Change it to a Money type
    private String description;

    public Unit(String title, String region, int price) {
        this(title, region, price, null);
    }

    public Unit(String title, String region, int price, String description) {
        this.title = title;
        this.region = region;
        this.price = price;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getRegion() {
        return region;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unit unit = (Unit) o;
        return getPrice() == unit.getPrice() &&
                getTitle().equals(unit.getTitle()) &&
                getRegion().equals(unit.getRegion()) &&
                getDescription().equals(unit.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getRegion(), getPrice(), getDescription());
    }
}
