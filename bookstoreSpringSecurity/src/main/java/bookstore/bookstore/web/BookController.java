package bookstore.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;
import bookstore.bookstore.domain.CategoryRepository;

@Controller
public class BookController {
    @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryRepository crepository;

    // show all books
    @RequestMapping(value = "/booklist")
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

    // RESTful service to get all books
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> booktListRest() {
        return (List<Book>) repository.findAll();
    }

    // RESTful service to get book by id
    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
        return repository.findById(bookId);
    }

    // add new book
    @RequestMapping(value = "/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", crepository.findAll());
        return "addbook";
    }

    // save new book
    @PostMapping(value = "/save")
    public String save(Book book) {
        repository.save(book);
        return "redirect:booklist";
    }

    // delete book
    @GetMapping(value = "/delete/{id}")
    public String deleteBook(@PathVariable("id") Long bookId) {
        repository.deleteById(bookId);
        return "redirect:../booklist";
    }

    // edit book
    @GetMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("book", repository.findById(bookId));
        model.addAttribute("categories", crepository.findAll());
        return "updatebook";
    }

    @RequestMapping(value = { "/", "/home" })
    public String homeSecure() {
        return "home";
    }

    @RequestMapping(value = "/hello")
    public String helloSecure(Model model) {
        return "hello";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

}
