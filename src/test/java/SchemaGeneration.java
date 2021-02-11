import org.junit.Test;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class SchemaGeneration {


    @Test
    public void generateSchema() {
        final String persistenceUnitName = "default";
        EntityManager em = Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();
        em.close();
        em.getEntityManagerFactory().close();

    }
}
