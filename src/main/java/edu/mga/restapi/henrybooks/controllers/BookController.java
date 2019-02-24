package edu.mga.restapi.henrybooks.controllers;

import edu.mga.restapi.henrybooks.model.Book;
import edu.mga.restapi.henrybooks.services.BookService;
import edu.mga.restapi.henrybooks.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping(value = "/books/{id}", produces = "application/json")
    public @ResponseBody Book getBook(@PathVariable int id) {
        return bookService.getBook(id);
    }

    @GetMapping(value = "/books", produces = "application/json")
    public @ResponseBody List<Book> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping(value = "/books", consumes = "application/json")
    public void addBook(@RequestBody Book book) throws Exception {
        System.out.println("book = " + book);
        if (bookService.addBook(book))
            return;
        else
            throw new Exception("Unable to add book");
    }

    @PutMapping(value = "/books/{id}", consumes = "application/json")
    public boolean updateBook(@PathVariable int id, @RequestBody Book book) throws Exception {
        if (null == bookService.getBook(id) || null == book)
            throw new Exception("Unable to update book");

        // Just to make sure the pathparam id is the same as book.id
        book.setId(id);

        if (bookService.updateBook(book))
            return true;

        throw new Exception("Unable to update book");
    }

    @DeleteMapping(value = "/books/{id}")
    public boolean updateBook(@PathVariable int id) throws Exception {
        if (null == bookService.getBook(id))
            throw new Exception("Unable to find book to delete");

        if (bookService.deleteBook(id))
            return true;

        throw new Exception("Unable to update book");
    }

}
