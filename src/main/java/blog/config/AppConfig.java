package blog.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
//
//@EnableAspectJAutoProxy(proxyTargetClass = true)
@Configuration
@ComponentScan(basePackages = { "blog" })
//@PropertySource("classpath:/application.properties")
public class AppConfig {


	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigIn() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	public MultipartResolver multipartResolver(){
		MultipartResolver multipartResolver = new CommonsMultipartResolver();
		return multipartResolver;	
	}
}
