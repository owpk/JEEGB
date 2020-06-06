package hw_servlets;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateCatalogRunner {
    private final SessionFactory sessionFactory;
    private List<CatalogModel> catalogModel;

    public HibernateCatalogRunner() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        catalogModel = listOfProducts();
    }

    public List<CatalogModel> listOfProducts() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        List<CatalogModel> pojos = session.createQuery("FROM CatalogModel").list();
        transaction.commit();
        session.close();
        return pojos;
    }

    public List<CatalogModel> getCatalogModel() {
        return catalogModel;
    }
}
