package fi.haagahelia.customerlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.customerlist.domain.Customer;
import fi.haagahelia.customerlist.domain.CustomerDAOImpl;

@SpringBootApplication
public class CustomerlistApplication {
	private static final Logger log = LoggerFactory.getLogger(CustomerlistApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CustomerlistApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerDAOImpl customerDAO) {
		return (args) -> {
			// Database is created by using resources/schema.sql

			// Insert some demo data
			customerDAO.save(new Customer("John", "West"));
			customerDAO.save(new Customer("Mike", "Mars"));
			customerDAO.save(new Customer("Kate", "Johnson"));

		};
	}
}
