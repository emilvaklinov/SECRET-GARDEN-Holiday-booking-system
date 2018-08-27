import models.Area;
import models.Customer;
import models.Hotel;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

public class HotelTest {

    Hotel hotel1;

    Customer customer1;


    @Before
    public void before() {

        hotel1 = new Hotel("Bilyanska guest house", Area.BULGARIA, 100, 0);

        customer1 = new Customer("Emil", "Vaklinov", 100, 10, hotel1);

    }


    @Test
    public void hasName() {
        assertEquals("Bilyanska guest house", hotel1.getName());
    }

    @Test
    public void hotelHasArea(){
        assertEquals(Area.BULGARIA, hotel1.getArea());
    }

    @Test
    public void hotelHasPricePerNight(){
        assertEquals(100, hotel1.getPrice(), 0.01);
    }

    @Test
    public void hotelHasPoints(){
        assertEquals(0, hotel1.getPoints());
    }

    @Test
    public void hotelStartsEmpty(){
        assertEquals(0, hotel1.getCustomers().size());
    }


    @Test
    public void canCheckInCustomerToHotel(){
//        hotel1.checkInCustomer(customer1,hotel1);
        hotel1.checkInCustomer(customer1);
        assertEquals(1, hotel1.getCustomers().size());
    }

//    @Test
//    public void canCheckOutCustomerToHotel(){
//
//    }


//    public void canSetHotel() {
//        hotel.SetHotel(hotel);
//        assertEquals("Bilyanska guest house", hotel.getName());
//    }
//
//    @Test
//    public void canGetCustomersCheckedIntoHotel() {
//        ArrayList<Customer> guestList = new ArrayList<Customer>();
//        guestList.add(customer1);
//        hotel.chekIn(guestList);
//        ArrayList<Customer> customers = hotel.getCustomersCheckedIntoHotel(hotel.getCustomers());
//        assertEquals(1, customers.size());
//        assertEquals("Vaklinov", customers.get(0).getId());
//    }


}