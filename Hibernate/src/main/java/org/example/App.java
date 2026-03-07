package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {

    public static void main(String[] args) {

        Configuration configuration = new Configuration()
                .configure()
                .addAnnotatedClass(User.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();


        User u = session.get(User.class, 1);

        if (u != null) {
            u.setEmail("helloooss@ooooomyyy.om");
            session.merge(u);
        }

//        List<User> list = session
//                .createQuery("from User", User.class)
//                .getResultList();
//
//        for (User user : list) {
//            System.out.println(user);
//        }

        session.close();
        sessionFactory.close();

        System.out.println("Update successful!");
    }
}