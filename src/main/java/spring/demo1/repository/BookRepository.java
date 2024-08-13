package spring.demo1.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.demo1.entity.BookEntity;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Integer> {
    List<BookEntity> findByAuthor(String author);

    List<BookEntity> findByAuthorAndPrice(String name, double price);

    List<BookEntity> findByPriceOrNumberofPage(double price, int numberofPage);

    List<BookEntity> findByPriceLessThan(double price);

    List<BookEntity> findByPriceGreaterThanEqual(double price);

    List<BookEntity> findByNameContaining(String searchWords);

    BookEntity findByIsbn(String isbn);

    List<BookEntity> findByPublishDateAfter(LocalDate date);

    @Query("select b from BookEntity b where b.name like ?1%")
    List<BookEntity> getBookNameStartWith(String name);//?1 : param 1, ?2: param 2

    @Query(value = "select * from book b where b.price < ?1 and b.numberPage > = ?2", nativeQuery = true)
    List<BookEntity> getBookWherePriceLessThanAndNumberOfPageGreaterThan(double price, int numOfPage);

}