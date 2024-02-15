package bookstore.bookstore.web;

import org.springframework.stereotype.Controller;

@Controller
public class BookController {
    // @Autowired
    // private BookRepository repository;

    // @Autowired
    // private CategoryRepository crepository;

    // // show all books
    // @RequestMapping(value = "/booklist")
    // public String bookList(Model model) {
    // model.addAttribute("books", repository.findAll());
    // return "booklist";
    // }

    // // RESTful service to get all books
    // @RequestMapping(value = "/books", method = RequestMethod.GET)
    // public @ResponseBody List<Book> booktListRest() {
    // return (List<Book>) repository.findAll();
    // }

    // // RESTful service to get book by id
    // @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    // public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long
    // bookId) {
    // return repository.findById(bookId);
    // }

    // // add new book
    // @RequestMapping(value = "/add")
    // public String addBook(Model model) {
    // model.addAttribute("book", new Book());
    // model.addAttribute("categories", crepository.findAll());
    // return "addbook";
    // }

    // // save new book
    // @PostMapping(value = "/save")
    // public String save(Book book) {
    // repository.save(book);
    // return "redirect:booklist";
    // }

    // // delete book
    // @GetMapping(value = "/delete/{id}")
    // public String deleteBook(@PathVariable("id") Long bookId) {
    // repository.deleteById(bookId);
    // return "redirect:../booklist";
    // }

    // // edit book
    // @GetMapping(value = "/edit/{id}")
    // public String editBook(@PathVariable("id") Long bookId, Model model) {
    // model.addAttribute("book", repository.findById(bookId));
    // model.addAttribute("categories", crepository.findAll());
    // return "updatebook";
    // }

    // @GetMapping("/hello")
    // public @ResponseBody String greeting() {
    // return "Hello World";
    // }

}
