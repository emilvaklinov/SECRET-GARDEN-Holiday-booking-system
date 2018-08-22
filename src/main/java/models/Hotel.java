package models;

import javax.persistence.*;

@Entity
@Table(name = "hotels")
public class Hotel {

    private int id;
    private String name;
    private String area;
    private double price;
    private int points;


    public Hotel(){}


    public Hotel(String name, String area, double price, int points) {
        this.name = name;
        this.area = area;
        this.price = price;
        this.points = points;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "area")
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Column(name = "points")
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
