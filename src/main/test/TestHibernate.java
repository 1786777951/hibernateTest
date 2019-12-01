package main.test;

import main.bean.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.List;


public class TestHibernate {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();
        //插入数据
//        for(int i = 0;i<10;i++) {
//            Product p = new Product();
//            p.setName("洋葱");
//            p.setPrice(7000);
//            //此时p是瞬时状态的
//            s.save(p);
//            //此时p是持久状态的
//        }

        //查询
//      Product p = s.get(Product.class,6);
//      System.out.println("id为6的是"+p.getName());

        //删除
//      Product p = s.get(Product.class,6);
//      s.delete(p);

        //修改
//        Product p = s.get(Product.class,5);
//        p.setName("洋葱5");
//        s.update(p);

        //使用Query
//        String name = "洋葱";
//        Query q = s.createQuery("from Product p where p.name like ?0");
//        q.setParameter(0,name);
//        List<Product> ps = q.list();
//        for(Product p : ps){
//            System.out.println(p.getName());
//        }

        //使用Criteria
//        String name = "洋葱";
//        Criteria c = s.createCriteria(Product.class);
//        c.add(Restrictions.like("name","%"+name+"%"));
//        List<Product> ps = c.list();
//        for (Product p : ps){
//            System.out.println(p.getName());
//        }

        //使用标准
        String name = "洋葱";
        String sql = "select * from product_ p where p.name like '%"+name+"%'";
        Query q = s.createSQLQuery(sql);
        List<Object[]> list = q.list();
        for(Object[] os : list){
            for (Object filed : os){
                System.out.println(filed+"\t");
            }
            System.out.println();
        }

        s.getTransaction().commit();
        s.close();
        //此时p是脱管状态
        sf.close();
    }
}
