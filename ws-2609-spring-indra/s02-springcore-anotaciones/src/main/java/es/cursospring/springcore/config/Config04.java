package es.cursospring.springcore.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.h2.jdbcx.JdbcDataSource;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

//@Configuration
//@PropertySource("classpath:config.properties")
//@ComponentScan("es.cursospring.springcore")
public class Config04 {

	@Autowired
	Environment prop;
	
	@Bean
	DataSource dataSource() {
		JdbcDataSource ds = new JdbcDataSource();
		ds.setURL(prop.getProperty("bd.h2.url"));
		ds.setUser(prop.getProperty("bd.h2.user"));
		return ds;
	}
	
	@Bean(initMethod = "start", destroyMethod = "stop")
	Server servidorH2Web() throws SQLException {
		return Server.createWebServer("-web", "-webPort", "8082");
	}
}
