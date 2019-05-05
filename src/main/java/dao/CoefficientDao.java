package dao;

import model.Coefficient;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CoefficientDao {

    public void createCoefficient(Coefficient coefficient) {
        Session session = SessionMeneger.getFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(coefficient);

        transaction.commit();
        session.close();
    }
}
