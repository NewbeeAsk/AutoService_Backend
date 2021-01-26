package com.autoservice.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "coordinates")
public class Coordinates implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "city cannot be empty")
    @Column(name = "city")
    String city;

    @NotNull(message = "coordinates cannot be empty")
    @Column(name = "lat")
    double lat;

    @NotNull(message = "coordinates cannot be empty")
    @Column(name = "lng")
    double lng;

    public Coordinates() {
    }

    public Coordinates(double lat, double lng, String city) {
        this.lat = lat;
        this.lng = lng;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
