package comex.dynamicquery.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import comex.dynamicquery.demo.entity.Book;

public interface BookRepository  extends JpaRepository<Book,Long>{

    //Dynamic query methods
    List<Book> findByAuthor(String author);
    List<Book> findByPriceGreaterThan(Double price);
    List<Book> findByTitleContainingAndPriceLessThan(String title,Double price);
    

    
}
