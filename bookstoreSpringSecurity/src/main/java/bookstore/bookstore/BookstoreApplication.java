package bookstore.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;
import bookstore.bookstore.domain.Category;
import bookstore.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {

			log.info("save a couple of books");
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Comedy"));
			crepository.save(new Category("Fiction"));

			brepository.save(new Book("The Night Circus", "Erin Morgenstern", 2011, "978-0385534635", 15,
					crepository.findByName("Fantasy").get(0)));
			brepository.save(new Book("The Martia", "Andy Weir", 2014, "978-0553418026", 14,
					crepository.findByName("Fiction").get(0)));
			brepository.save(new Book("Normal People", "Sally Rooney", 2018, "978-1984822178", 14,
					crepository.findByName("Comedy").get(0)));

			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
