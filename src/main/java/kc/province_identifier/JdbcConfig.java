package kc.province_identifier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class JdbcConfig {
    @Bean
    public DataSource mysqlDataSource() {
        Properties prop = new Properties();
        //prop.put("serverTimezone", "UTC");
        prop.put("reconnect", "true");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(System.getenv("JDBC_DATABASE_URL"));
        dataSource.setUsername(System.getenv("DATABASE_USERNAME"));
        dataSource.setPassword(System.getenv("DATABASE_PASSWORD"));
        dataSource.setConnectionProperties(prop);

        return dataSource;
    }
}