package com.rost;

import com.rost.Models.Principal;
import com.rost.Models.School;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Principal.class)
                .addAnnotatedClass(School.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

            

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}