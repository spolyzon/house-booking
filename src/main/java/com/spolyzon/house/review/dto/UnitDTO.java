package com.spolyzon.house.review.dto;

import com.spolyzon.house.review.domain.model.Unit;

import java.util.Objects;

public class UnitDTO implements DataTransferObject {
    private String title;
    private String region;
    private int price;
    private String description;

    public UnitDTO() { }

    public Unit getUnit() {
        return new Unit(this.getTitle(), this.getRegion(), this.getPrice(), this.getDescription());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
        UnitDTO unitDTO = (UnitDTO) o;
        return getPrice() == unitDTO.getPrice() &&
                Objects.equals(getTitle(), unitDTO.getTitle()) &&
                Objects.equals(getRegion(), unitDTO.getRegion()) &&
                Objects.equals(getDescription(), unitDTO.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getRegion(), getPrice(), getDescription());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UnitDTO{");
        sb.append("title='").append(title).append('\'');
        sb.append(", region='").append(region).append('\'');
        sb.append(", price=").append(price);
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
