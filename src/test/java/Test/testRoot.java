package Test;

import dao.RootDao;
import dao.SessionMeneger;
import model.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class testRoot {

    @Test
    public void testCreateRoot() {
        Root root = new Root();

        root.setX1(3.7);
        root.setX2(4.7);

        Session session = SessionMeneger.getFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(root);

        transaction.commit();
        session.close();
    }

    @Test
    public void testCreateRootDao() {
        Root root = new Root();

        root.setX1(33.7);
        root.setX2(4234.7);

        RootDao rootDao = new RootDao();
        rootDao.createRoot(root);
    }
}
