package ru.javarush.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.javarush.domain.City;

import java.util.List;

public class CityRepository {

    private final SessionFactory sessionFactory;

    public CityRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public City getById(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            Query<City> query = session.createQuery("select c from City c where c.id = :ID", City.class);
            query.setParameter("ID", id);
            return query.getSingleResult();
        }
    }

    public int totalCount() {
        try (Session session = sessionFactory.openSession()) {
            Query<Long> query = session.createQuery("select count(c) from City c", Long.class);

            return Math.toIntExact(query.uniqueResult());
        }
    }

    public List<City> getItems(int offset, int limit) {
        try (Session session = sessionFactory.openSession()) {
            Query<City> query = session.createQuery("select c from City c", City.class);
            query.setFirstResult(offset);
            query.setMaxResults(limit);

            return query.list();
        }
    }
}
