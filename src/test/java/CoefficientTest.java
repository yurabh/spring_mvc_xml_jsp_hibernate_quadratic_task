import dao.CoefficientImplDao;
import dao.SessionManager;
import domain.Coefficient;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class CoefficientTest {

    @Test
    public void testCreateCoefficient() {
        Coefficient coefficient = new Coefficient();

        coefficient.setA(1.8);
        coefficient.setB(2.8);
        coefficient.setC(3.9);

        Session session = SessionManager.getFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(coefficient);
        transaction.commit();
        session.close();
    }

    @Test
    public void testCreateCoefficientDao() {
        Coefficient coefficient = new Coefficient();

        coefficient.setA(13.8);
        coefficient.setB(23.8);
        coefficient.setC(34.9);

        CoefficientImplDao coefficientImplDao = new CoefficientImplDao();
        coefficientImplDao.create(coefficient);
    }
}
