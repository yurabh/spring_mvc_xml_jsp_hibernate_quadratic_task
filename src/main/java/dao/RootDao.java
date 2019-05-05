package dao;

import model.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RootDao {

    public void createRoot(Root root) {

        Session session = SessionMeneger.getFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(root);
        System.out.println();
        transaction.commit();
        session.close();
    }
}
