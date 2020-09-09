package dao;

import domain.Coefficient;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class CoefficientImplDao implements CoefficientDao {

    @Override
    public void create(Coefficient coefficient) {

        Session session = SessionManager.getFactory().openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(coefficient);

        transaction.commit();

        session.close();
    }
}
