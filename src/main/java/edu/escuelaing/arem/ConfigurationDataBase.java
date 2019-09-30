package edu.escuelaing.arem;


import java.sql.SQLException;
import javax.sql.DataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;


@Component
public class ConfigurationDataBase {
	
	@Value("${spring.datasource.url}")
	private String databaseUrl;
	@Value("${spring.datasource.username}")
	private String databaseUsername;
	@Value("${spring.datasource.password}")
	private String databasePassword;
	
	
	@Bean
	public DataSource dataSource() throws SQLException {
		if (databaseUrl == null || databaseUrl.isEmpty()) {
			return new HikariDataSource();
		} else {
			HikariConfig config = new HikariConfig();
			config.setJdbcUrl(databaseUrl);
			config.setUsername(databaseUsername);
			config.setPassword(databasePassword);
			config.setMaximumPoolSize(2);
			return new HikariDataSource(config);
		}
	}
	
}