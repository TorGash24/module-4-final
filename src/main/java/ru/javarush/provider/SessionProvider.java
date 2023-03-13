package ru.javarush.provider;

import org.hibernate.SessionFactory;

public interface SessionProvider {

    SessionFactory getSessionFactory();
}
