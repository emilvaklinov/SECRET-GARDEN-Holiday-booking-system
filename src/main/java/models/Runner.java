package models;

import db.DBHelper;
import db.GardensHelper;

import java.util.List;


public class Runner {

    public static void main(String[] args) {

        DBHelper.deleteAll(Customer.class);
        DBHelper.deleteAll(Flower.class);
        DBHelper.deleteAll(Hotel.class);
        DBHelper.deleteAll(Area.class);


        Area area1 = new Area("Bulgaria");
        Area area2 = new Area("Greece");
        Area area3 = new Area("Scotland");
        Area area4 = new Area("Japan");
        Area area5 = new Area("Hungary");
        Area area6 = new Area("Australia");
        Area area7 = new Area("Ecuador");

        DBHelper.save(area1);
        DBHelper.save(area2);
        DBHelper.save(area3);
        DBHelper.save(area4);
        DBHelper.save(area5);
        DBHelper.save(area6);
        DBHelper.save(area7);

        Hotel hotel1 = new Hotel("Bilyanska guest house", area1, 100, 0);
        DBHelper.save(hotel1);
        Hotel hotel2 = new Hotel("Calipso", area2, 100, 0);
        DBHelper.save(hotel2);
        Hotel hotel3 = new Hotel("Glen Eagle", area3, 100, 0);
        DBHelper.save(hotel3);
        Hotel hotel4 = new Hotel("Holiday Inn", area4, 100, 0);
        DBHelper.save(hotel4);
        Hotel hotel5 = new Hotel("Art hotel", area5, 100, 0);
        DBHelper.save(hotel5);
        Hotel hotel6 = new Hotel("Kenguro bagpacker", area6, 100, 0);
        DBHelper.save(hotel6);
        Hotel hotel7 = new Hotel("Amigo", area7, 100, 0);
        DBHelper.save(hotel7);

        Customer customer1 = new Customer("Emil", "Vaklinov", 100, 10, hotel1);
        DBHelper.save(customer1);

        hotel1.addCustomer(customer1);
        DBHelper.update(hotel1);
        hotel2.addCustomer(customer1);
        DBHelper.update(hotel2);
        hotel3.addCustomer(customer1);
        DBHelper.update(hotel3);
        hotel4.addCustomer(customer1);
        DBHelper.update(hotel4);
        hotel5.addCustomer(customer1);
        DBHelper.update(hotel5);
        hotel6.addCustomer(customer1);
        DBHelper.update(hotel6);
        hotel7.addCustomer(customer1);
        DBHelper.update(hotel7);


        Flower flower1 = new Flower("Haberlea Rhodopensis", "Evergreen Endemic", area1, 6);
        DBHelper.save((flower1));
        Flower flower2 = new Flower("Haberlea Rhodopensis", "Evergreen Endemic", area2, 5);
        DBHelper.save((flower2));
        Flower flower3 = new Flower("Scottish Primrose (Primula scotica)", "Endemic", area3, 6);
        DBHelper.save(flower3);
        Flower flower4 = new Flower("Sakura (Cherry Blossom)", "Endemic", area4, 5);
        DBHelper.save(flower4);
        Flower flower5 = new Flower("Fehér tündérrózsa (Nymphaea alba)", "Endemic", area5, 5);
        DBHelper.save(flower5);
        Flower flower6 = new Flower("Kangaroo Paw (Macropidia fulginosa)", "Endemic", area6, 10);
        DBHelper.save(flower6);
        Flower flower7 = new Flower("Dracula vampira", "Endemic", area7, 7);
        DBHelper.save(flower7);
        Flower flower8 = new Flower("Lilium Rodopeum Delip", "Endemic", area1, 5);
        DBHelper.save((flower8));


        GardensHelper.addCustomerFlower(customer1, flower1);

        List<Flower> customerGetFlower = GardensHelper.getCustomerFlower(customer1);
        List<Customer> flowerGetCustomer = GardensHelper.getFlowerCustomer(flower1);
    }
}
