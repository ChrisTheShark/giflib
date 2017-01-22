package com.dyer.frameworks.repository;

import com.dyer.frameworks.model.Gif;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * {@link GifRepository} implementation uses a Hibernate {@link Session}
 * to access {@link Gif} data.
 */
@Repository
public class GifRepositoryImpl implements GifRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Gif findById(Long identifier) {
        Session session = sessionFactory.openSession();
        Gif gif = session.get(Gif.class, identifier);
        session.close();
        return gif;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Gif> findAll() {
        Session session = sessionFactory.openSession();
        List<Gif> gifs = session.createCriteria(Gif.class).list();
        session.close();
        return gifs;
    }

    @Override
    public void save(Gif gif) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(gif);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Gif gif) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(gif);

        session.getTransaction().commit();
        session.close();
    }

}
