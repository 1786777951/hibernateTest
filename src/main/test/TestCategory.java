package main.test;

import main.bean.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class TestCategory {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        Session s = sf.openSession();
        s.beginTransaction();

        Category c = new Category();
        c.setName("洋葱");

        s.save(c);

        s.getTransaction().commit();
        s.close();
        sf.close();
    }


}
