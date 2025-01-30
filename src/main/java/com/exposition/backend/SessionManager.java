package com.exposition.backend;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SessionManager<Template> {
    private final SessionFactory sessionFactory;

    public SessionManager(Class<Template> _class) throws Throwable {
        Configuration configuration = new Configuration().configure("./src/main/resources/hibernate.cfg.xml");
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

    public void insertEntity(Template entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            session.persist(entity);
            transaction.commit();
        } catch (Throwable e) {}
    }

    public void saveEntity(Template entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            session.merge(entity);
            transaction.commit();
        } catch (Throwable e) {}
    }

}
