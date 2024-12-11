package dev.lubna.JA;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class JaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JaApplication.class, args);
	}

	@Bean
	public PlatformTransactionManager transactionManager (EntityManagerFactory emf ){
		return  new JpaTransactionManager( emf) ;
	}

}
