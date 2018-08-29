package db;

import models.Area;
import models.Customer;
import models.Flower;
import models.Hotel;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBHotel {

    private static Session session;


    public static List<Hotel> getHotelByArea(Area area) {
        List<Hotel> results  = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr = session.createCriteria(Hotel.class);
            cr.add(Restrictions.eq("area", area));
            results =  cr.list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;

    }


}
