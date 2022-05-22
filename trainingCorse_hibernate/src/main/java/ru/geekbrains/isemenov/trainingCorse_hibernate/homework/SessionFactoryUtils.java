package ru.geekbrains.isemenov.trainingCorse_hibernate.homework;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SessionFactoryUtils {
    private static SessionFactory factory;

    @PostConstruct
    public void init() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static Session getSession() {
        return factory.getCurrentSession();
    }

    public static void shutdown() {
        if (factory != null) {
            factory.close();
        }
    }
}
