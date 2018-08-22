package models;

import db.DBHelper;

public class Runner {

    public static void main(String[] args) {

        DBHelper.deleteAll(Customer.class);
        DBHelper.deleteAll(Flower.class);
        DBHelper.deleteAll(Hotel.class);
        DBHelper.deleteAll(Area.class);

        Customer customer1 = new Customer("Emil", "Vaklinov", 100, 10);
        DBHelper.save(customer1);


    }
}
