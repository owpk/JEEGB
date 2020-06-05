package hw_servlets;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class HibernateCatalogRunner {
    //private final SessionFactory sessionFactory;
    private List<CatalogModel> catalogModel;

    public HibernateCatalogRunner() {
        //выбрасывает org.hibernate.HibernateException: Unable to instantiate default tuplizer [org.hibernate.tuple.entity.PojoEntityTuplizer]
        //sessionFactory = new Configuration().configure().buildSessionFactory();
        catalogModel = new ArrayList<>();
        catalogModel.add(new CatalogModel("apple",150,"green"));
        catalogModel.add(new CatalogModel("phone",1000,"x-5"));
        catalogModel.add(new CatalogModel("water",5000,"just water"));
    }

//    private List<CatalogModel> listOfProducts() {
//        //Session session = sessionFactory.openSession();
//        Transaction transaction = null;
//        transaction = session.beginTransaction();
//
//        List<CatalogModel> pojos = session.createQuery("FROM CatalogModel").list();
//        transaction.commit();
//        session.close();
//        return pojos;
//    }

    public List<CatalogModel> getCatalogModel() {
        return catalogModel;
    }
}
