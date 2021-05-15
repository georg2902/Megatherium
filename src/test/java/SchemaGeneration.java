import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.rolofge.application.config.JpaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {JpaConfig.class})
public class SchemaGeneration {

    @Autowired
    private LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean;

    @Test
    public void generateSchema() {
        EntityManager entityManager = localContainerEntityManagerFactoryBean.getNativeEntityManagerFactory().createEntityManager();
        entityManager.close();
    }
}
