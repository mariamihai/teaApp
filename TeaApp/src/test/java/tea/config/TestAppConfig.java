package tea.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import app.util.ConfigProfil;

@Configuration
@EnableTransactionManagement
@ComponentScan("tea")
@EnableJpaRepositories("tea.dao")
@Profile(ConfigProfil.TEST)
public class TestAppConfig {
	
	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
			.setType(EmbeddedDatabaseType.HSQL)
			.ignoreFailedDrops(true)
			.setName("testdb")
			.addScript("classpath:/config/sql/testData/test_schema.sql")
			.addScript("classpath:/config/sql/testData/test_data.sql")
			.build();
	}
	
	@Bean
	public HibernateJpaVendorAdapter hibernateJpaVendor() { 
		return new HibernateJpaVendorAdapter(); 
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslaction() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

}
