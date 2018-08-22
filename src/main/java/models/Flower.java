package models;

import javax.persistence.*;

@Entity
@Table(name = "flowers")
public class Flower {

    private int id;
    private String name;
    private String type;
    private String area;
    private int points;


    public Flower(){}

    public Flower(String name, String type, String area, int points) {
        this.name = name;
        this.type = type;
        this.area = area;
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

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "area")
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Column(name = "points")
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
