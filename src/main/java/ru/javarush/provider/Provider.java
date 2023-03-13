package ru.javarush.provider;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.javarush.domain.City;
import ru.javarush.domain.Country;
import ru.javarush.domain.CountryLanguage;

public class Provider implements SessionProvider {


    @Override
    public SessionFactory getSessionFactory() {
        return new Configuration()
                .addAnnotatedClass(City.class)
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(CountryLanguage.class)
                .buildSessionFactory();
    }
}
