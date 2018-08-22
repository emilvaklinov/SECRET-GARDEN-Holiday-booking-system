package models;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    private int id;
    private String firstName;
    private String lastName;
    private double money;
    private int points;

    public Customer(){}

    public Customer(String firstName, String lastName, double money, int points) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.money = money;
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

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "money")
    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Column(name = "points")
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
