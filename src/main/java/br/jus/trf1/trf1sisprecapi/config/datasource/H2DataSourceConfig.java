package br.jus.trf1.trf1sisprecapi.config.datasource;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * Configurações do datasource do H2
 *
 * <p>
 *      ATENÇÃO: As entidades gerenciadas por esse datasource devem
 *      ficar dentro da package br.jus.trf1.trf1sisprecapi.model
 * </p>
 * <p>
 *     ATENÇÃO: O datasource do H2 será adicionado automaticamente
 *     para todos os repositórios que forem criados dentro da package br.jus.trf1.trf1sisprecapi.repository
 * </p>
 *
 * @author bruno.carneiro (tr301605)
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "br.jus.trf1.trf1sisprecapi.system.repository",
        entityManagerFactoryRef = "h2EntityManagerFactory",
        transactionManagerRef = "h2TransactionManager"
)
public class H2DataSourceConfig {

    @Primary
    @Bean(name = "h2DataSource")
    @ConfigurationProperties(prefix = "spring.h2.datasource")
    public DataSource h2DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "h2EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean h2EntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("h2DataSource") DataSource dataSource) {
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        return builder
                .dataSource(dataSource)
                .properties(properties)
                .packages("br.jus.trf1.trf1sisprecapi.system")
                .persistenceUnit("h2")
                .build();
    }

    @Bean(name = "h2TransactionManager")
    public JpaTransactionManager h2TransactionManager(@Qualifier("h2EntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
