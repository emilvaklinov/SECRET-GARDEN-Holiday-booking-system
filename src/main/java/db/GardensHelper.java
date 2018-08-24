package db;

import models.Customer;
import models.Flower;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class GardensHelper {

    private static Session session;

    public static void addCustomerFlower(Customer customer, Flower flower) {
        customer.addFlower(flower);
        DBHelper.update(customer);
    }

    public static List<Flower> getCustomerFlower(Customer customer) {
        List<Flower> results = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr = session.createCriteria(Flower.class);
            cr.createAlias("customers", "customer");
            cr.add(Restrictions.eq("customer.id", customer.getId()));
            results = cr.list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;

    }

    public static List<Customer> getFlowerCustomer(Flower flower) {
        List<Customer> results = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr = session.createCriteria(Customer.class);
            cr.createAlias("flowers", "flower");
            cr.add(Restrictions.eq("flower.id", flower.getId()));
            results = cr.list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return results;
}
}