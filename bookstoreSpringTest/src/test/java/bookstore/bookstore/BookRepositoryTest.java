package bookstore.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;
import bookstore.bookstore.domain.Category;
import bookstore.bookstore.domain.CategoryRepository;

import org.junit.jupiter.api.Test;

@SpringBootTest(classes = BookstoreApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTest {
    @Autowired
    private BookRepository brepository;

    @Autowired
    private CategoryRepository crepository;

    @Test
    public void findByAuthorShouldReturnAuthor() {
        List<Book> books = brepository.findByAuthor("Andy Weir");
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("The Martia");
    }

    @Test
    public void createNewBook() {
        Category category = new Category("horror");
        crepository.save(category);
        Book book = new Book("Things We Say in the Dark", "Kisty Logan", 2020, "9781529111286", 12, category);
        brepository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void deleteNewBook() {
        List<Book> books = brepository.findByAuthor("Andy Weir");
        Book book = books.get((0));
        brepository.delete(book);
        List<Book> newBooks = brepository.findByAuthor("Andy Weir");
        assertThat(newBooks).hasSize(0);
    }
}
