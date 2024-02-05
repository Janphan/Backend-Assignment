package bookstore.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			repository.save(new Book("The Night Circus", "Erin Morgenstern", 2011, "978-0385534635", 15));
			repository.save(new Book("The Martia", "Andy Weir", 2014, "978-0553418026", 14));
			repository.save(new Book("Normal People", "Sally Rooney", 2018, "978-1984822178", 14));

			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
