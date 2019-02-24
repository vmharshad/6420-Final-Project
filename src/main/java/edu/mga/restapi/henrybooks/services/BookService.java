package edu.mga.restapi.henrybooks.services;

import edu.mga.restapi.henrybooks.model.Book;
import edu.mga.restapi.henrybooks.repositories.BookRepository;
import edu.mga.restapi.henrybooks.repositories.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public boolean addBook(Book book) {
        System.out.println(bookRepository.save(book));
        return true;
    }

    @Transactional
    public boolean updateBook(Book book) {
        Book book1 = bookRepository.findById(book.getId());
        if (null == book1)
            return false;
        bookRepository.save(book);
        return true;
    }

    @Transactional
    public boolean deleteBook(Integer id) {
        Book book = bookRepository.findById(id);
        if (null == book)
            return false;
//        bookList.remove(id);
        bookRepository.deleteById(id);
        return true;
    }

    public Book getBook(Integer id) {
//        return bookList.get(id);
        return bookRepository.findById(id);
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

}
