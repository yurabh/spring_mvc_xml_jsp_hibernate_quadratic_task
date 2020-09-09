import dao.RootImplDao;
import dao.SessionManager;
import domain.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class RootTest {

    @Test
    public void testCreateRoot() {
        Root root = new Root();

        root.setX1(3.7);
        root.setX2(4.7);

        Session session = SessionManager.getFactory().openSession();
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

        RootImplDao rootImplDao = new RootImplDao();
        rootImplDao.create(root);
    }
}
