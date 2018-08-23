package models;

import db.DBHelper;


public class Runner {

    public static void main(String[] args) {

        DBHelper.deleteAll(Customer.class);
        DBHelper.deleteAll(Flower.class);
        DBHelper.deleteAll(Hotel.class);
        DBHelper.deleteAll(Area.class);


        Customer customer1 = new Customer("Emil", "Vaklinov", 100, 10, hotel1 );
        DBHelper.save(customer1);


        Hotel hotel1 = new Hotel("Bilyanska guest house", Area.BULGARIA, 100, 0, customer1);
        DBHelper.save(hotel1);
        Hotel hotel2 = new Hotel("Calipso", Area.GREECE, 100, 0, customer1);
        DBHelper.save(hotel2);
        Hotel hotel3 = new Hotel("Glen Eagle", Area.SCOTLAND, 100, 0, customer1);
        DBHelper.save(hotel3);
        Hotel hotel4 = new Hotel("Holiday Inn", Area.JAPAN, 100, 0, customer1);
        DBHelper.save(hotel4);
        Hotel hotel5 = new Hotel("Art hotel", Area.HUNGARY, 100, 0, customer1);
        DBHelper.save(hotel5);
        Hotel hotel6 = new Hotel("Kenguro bagpacker", Area.AUSTRALIA, 100, 0, customer1);
        DBHelper.save(hotel6);
        Hotel hotel7 = new Hotel("Amigo", Area.ECUADOR, 100, 0, customer1);
        DBHelper.save(hotel7);

        Flower flower1 = new Flower("Haberlea Rhodopensis","Evergreen Endemic", Area.BULGARIA,6, customer1);
        DBHelper.save((flower1));
        Flower flower2 = new Flower("Haberlea Rhodopensis","Evergreen Endemic",Area.GREECE,5, customer1);
        DBHelper.save((flower2));
        Flower flower3 = new Flower("Scottish Primrose (Primula scotica)", "Endemic", Area.SCOTLAND, 6, customer1);
        DBHelper.save(flower3);
        Flower flower4 = new Flower("Sakura (Cherry Blossom)", "Endemic", Area.JAPAN, 5, customer1);
        DBHelper.save(flower4);
        Flower flower5 = new Flower("Fehér tündérrózsa (Nymphaea alba)", "Endemic", Area.HUNGARY, 5, customer1);
        DBHelper.save(flower5);
        Flower flower6 = new Flower("Kangaroo Paw (Macropidia fulginosa)", "Endemic", Area.AUSTRALIA, 10, customer1);
        DBHelper.save(flower6);
        Flower flower7 = new Flower("Dracula vampira", "Endemic", Area.ECUADOR, 7, customer1);
        DBHelper.save(flower7);
        Flower flower8 = new Flower("Lilium Rodopeum Delip","Endemic",Area.BULGARIA,5, customer1);
        DBHelper.save((flower8));






//        Customer found = DBHelper.find();
//        Flower foundFlower = DBHelper.findFlowersForCustomer(flower);


//        List<Flower>
     }
}
