package edu.mga.restapi.henrybooks.repositories;

import edu.mga.restapi.henrybooks.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAll();
    Book findById(Integer id);
    Book save(Book book);
    void deleteById(Integer id);

}
