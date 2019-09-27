package com.stackroute.keepnote;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.spi.SessionFactoryServiceRegistryBuilder;

public class App {

    public static void main(String[] args)
    {
        Alien alien=new Alien();   // you can also do =null coz in the end hibernate will make it for you.
        alien.setAid(103);
        alien.setaName("thanos");
        alien.setColor("violet");

        Configuration conf=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
        SessionFactory sf=conf.buildSessionFactory();
/*********************************************************************This was example of first level caching
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();
        //session.saveOrUpdate(alien);

        Alien a1=(Alien)session.get(Alien.class,102);
        System.out.println(a1);

        Alien a2=(Alien)session.get(Alien.class,102);
        System.out.println(a2);
         /**************************************************************************/
        //session.save(alien);
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();
        Alien a1=(Alien)session.get(Alien.class,102);
        System.out.println(a1);
        tx.commit();
        session.close();

        Session session2=sf.openSession();
        Transaction tx2=session2.beginTransaction();
        Alien a2=(Alien)session2.get(Alien.class,102);
        System.out.println(a2);
        tx2.commit();
        session2.close();

    }
}
