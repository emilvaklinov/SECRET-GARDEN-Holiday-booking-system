package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hotels")
@Inheritance(strategy = InheritanceType.JOINED)
public class Hotel {

    private int id;
    private String name;
    private Area area;
    private double price;
    private int points;
    //    private Customer customer;
    private List<Customer> customers;


    public Hotel() {
    }


    public Hotel(String name, Area area, double price, int points) {
        this.name = name;
        this.area = area;
        this.price = price;
        this.points = points;
        // this.customer = customer;
        this.customers = new ArrayList<Customer>();
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
    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
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

    @OneToMany(mappedBy = "hotel")
    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }



    public boolean checkInCustomer(Customer customer) {
        if (!customers.contains(customer)) {
                customers.add(customer);
                if (customer.getPoints() <= 9){
                    customer.makePayment(this.price);
                } else {
                    customer.takePoints(10);
                    customer.makePayment(this.price - 10);
                }
                return true;
            } else {
                return false;
            }

    }


//    public boolean checkOutCustomer(ArrayList<Customer>customers) {
//
//        if (hotel.contains(hotel)) {
//            ArrayList<Customer> currentCustomers = hotel.getCurrentCustomers();
//
//            if (currentCustomers.contains(customers)) {
//                room.removeGuest(customers);
//                return true;
//            } else {
//                return false;
//            }
//        } else {
//            return false;
//        }
//    }
}