package hw_jsf.repos;

import hw_jsf.models.BaseItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public abstract class BaseRepository<T extends BaseItem> {

    private final SessionFactory sessionFactory;

    private String modelName;

    protected abstract String obtainName();

    public BaseRepository() {
        modelName = obtainName();
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public List<T> itemList() {
        Session session = sessionFactory.openSession();
        Transaction transaction;
        transaction = session.beginTransaction();

        List<T> pojos = session.createQuery("FROM " + modelName).list();
        transaction.commit();
        session.close();
        return pojos;
    }

    public void add(T element) {
        Session session = sessionFactory.openSession();
        Transaction transaction;
        transaction = session.beginTransaction();

        session.save(element);
        transaction.commit();
        session.close();
    }

    public void remove(T element) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        session.delete(element);
        transaction.commit();
        session.close();
    }
}
