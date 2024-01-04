package comex.dynamicquery.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import comex.dynamicquery.demo.Repository.BookRepository;
import comex.dynamicquery.demo.entity.Book;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookRepository bookRepo;
    @GetMapping("/byAuthor")
    public List<Book> getBooksByAuthor(@RequestParam String author)
    {
        return bookRepo.findByAuthor(author);
    }
    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam String keyword,@RequestParam Double maxprice)
    {
        return bookRepo.findByTitleContainingAndPriceLessThan(keyword,maxprice);
    }
    @GetMapping("/expensivebooks")
    public List<Book> getExpensiveBooks(@RequestParam Double price)
    {
        return bookRepo.findByPriceGreaterThan(price);
    }

}
