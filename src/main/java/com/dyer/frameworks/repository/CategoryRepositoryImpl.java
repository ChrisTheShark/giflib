package com.dyer.frameworks.repository;

import com.dyer.frameworks.model.Category;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * {@link CategoryRepository} implementation uses a Hibernate {@link org.hibernate.Session}
 * to access {@link com.dyer.frameworks.model.Category} data.
 */
@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Category findById(Long id) {
        Session session = sessionFactory.openSession();
        Category category = session.get(Category.class, id);
        session.close();
        return category;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Category> findAll() {
        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(Category.class);
        List<Category> categories = criteria.list();

        session.close();
        return categories;
    }

    @Override
    public void save(Category category) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(category);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Category category) {
        Session session = sessionFactory.openSession();
        session.delete(category);
        session.close();
    }

}
