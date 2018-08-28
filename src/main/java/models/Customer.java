package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "customers")
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer {

    private int id;
    private String firstName;
    private String lastName;
    private double money;
    private int points;
    private List<Flower> flowers;
    private Hotel hotel;


    public Customer() {
    }

    public Customer(String firstName, String lastName, double money, int points , Hotel hotel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.money = money;
        this.points = points;
        this.hotel = hotel;
        this.flowers = new ArrayList<Flower>();

    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.money = 0;
        this.points = 0;
        this.flowers = new ArrayList<Flower>();

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

//    @OneToMany(mappedBy = "customer")

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name = "customers_flowers",
            joinColumns = {@JoinColumn(name = "customer_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "flower_id", nullable = false, updatable = false)})
    public List<Flower> getFlowers() {
        return flowers;
    }

    public void setFlowers(List<Flower> flowers) {
        this.flowers = flowers;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id", nullable = true)
    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void addFlower(Flower flower) {
        this.flowers.add(flower);
    }

    public void makePayment(Double amount){
        Double money = this.money;
        if (this.money >= amount){
            this.money -= amount;
        } else {
            this.money = money;
        }
    }

    public void takePoints(int numPoints){
        int points = this.points;
        if(this.points >= numPoints){
            this.points -= numPoints;
        } else {
            this.points = points;
        }
    }
}
