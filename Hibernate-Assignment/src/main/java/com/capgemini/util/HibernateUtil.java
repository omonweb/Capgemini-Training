package com.capgemini.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory factory;

    static {
        factory = new Configuration()
                .configure()
                .addAnnotatedClass(com.capgemini.entity.Student.class)
                .buildSessionFactory();
    }

    public static SessionFactory getFactory() {
        return factory;
    }

    public static void shutdown() {
        factory.close();
    }
}