package br.jus.trf1.trf1sisprecapi.config.datasource;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * Configurações do datasource do PostgreSQL
 *
 * <p>
 *     ATENÇÃO: As entidades gerenciadas por esse datasource devem
 *     ficar dentro da package br.jus.trf1.trf1sisprecapi.sirea.model
 * </p>
 * <p>
 *     ATENÇÃO: O datasource do PostgreSQL será adicionado automaticamente
 *     para todos os repositórios que forem criados dentro da package br.jus.trf1.trf1sisprecapi.sirea
 * </p>
 *
 * @author bruno.carneiro (tr301605)
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "br.jus.trf1.trf1sisprecapi.sirea.repository",
        entityManagerFactoryRef = "postgresqlEntityManagerFactory",
        transactionManagerRef = "postgresqlTransactionManager"
)
@EntityScan(basePackages = "br.jus.trf1.trf1sisprecapi.sirea.model")
public class PostgresDatasourceConfig {

    @Bean(name = "postgresqlDataSource")
    @ConfigurationProperties(prefix = "spring.postgresql.datasource")
    public DataSource postgresDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "postgresqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean postgresqlEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("postgresqlDataSource") DataSource dataSource) {
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("org.hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        return builder
                .dataSource(dataSource)
                .properties(properties)
                .packages("br.jus.trf1.trf1sisprecapi.sirea")
                .persistenceUnit("postgresql")
                .build();
    }

    @Bean(name = "postgresqlTransactionManager")
    public JpaTransactionManager postgresqlTransactionManager(@Qualifier("postgresqlEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
