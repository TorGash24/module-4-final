package ru.javarush.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.javarush.domain.Country;

import java.util.List;

public class CountryRepository {
    private final SessionFactory sessionFactory;

    public CountryRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Country> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Country> query = session.createQuery("select c from Country c", Country.class);

            return query.list();
        }
    }
}
