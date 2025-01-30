package com.exposition.backend;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class SessionManager<Template> {
    private final SessionFactory sessionFactory;
    private final int OPP = 10; //objects per page

    public SessionManager(Class<Template> _class) throws Throwable {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(_class);
        sessionFactory = configuration.buildSessionFactory();
    }

    public Template getByName(Class<Template> _class,String name) {
        try (Session session = sessionFactory.openSession()) {

            return session.get(_class, name);
        } catch (Throwable e) {}
        return null;
    }
    
    public Template getById(Class<Template> _class,int id) {
        try (Session session = sessionFactory.openSession()) {

            return session.get(_class, id);
        } catch (Throwable e) {}
        return null;
    }

    public List<Game> getElements(int page) {
        int offset = page * OPP;
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Game WHERE id > :offset ORDER BY id";
            Query<Game> query = session.createQuery(hql, Game.class);
            query.setParameter("offset", offset);
            query.setMaxResults(10); // Limit to 10 results
            
            return query.getResultList();
        } catch (Throwable e) {}
        return null;
    }

    public boolean deleteEntity(Template entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            session.remove(entity);
            transaction.commit();
            return true;
        } catch (Throwable e) {}
        return false;
    }

    public boolean insertEntity(Template entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            session.persist(entity);
            transaction.commit();
            return true;
        } catch (Throwable e) {}
        return false;
    }

    public boolean saveEntity(Template entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            session.merge(entity);
            transaction.commit();
            return true;
        } catch (Throwable e) {}
        return false;
    }

}
