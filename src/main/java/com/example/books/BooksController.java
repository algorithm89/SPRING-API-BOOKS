package com.example.books;
import java.nio.file.Path;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class BooksController {
    //autowire the BooksService class
    @Autowired
    BooksService booksService;
    //creating a get mapping that retrieves all the books detail from the database

    @GetMapping("/api/v1/books")
    private List<Books> getAllBooks()
    {
        return booksService.getAllBooks();
    }
    //creating a get mapping that retrieves the detail of a specific book
    @GetMapping("/api/v1/books/{bookid}")
    private Books getBooks(@PathVariable("bookid") int bookid)
    {
        return booksService.getBooksById(bookid);
    }
    //creating a delete mapping that deletes a specified book
    @DeleteMapping("/api/v1/books/{bookid}")
    private void deleteBook(@PathVariable("bookid") int bookid)
    {
        booksService.delete(bookid);
    }

    //creating post mapping that post the book detail in the database
    @PostMapping("/api/v1/books/books")
    private int saveBook(@RequestBody Books books)
    {
        booksService.saveOrUpdate(books);
        return books.getBookid();
    }
    //creating put mapping that updates the book detail
    @PutMapping("/api/v1/books/books")
    private Books update(@RequestBody Books books)
    {
        booksService.saveOrUpdate(books);
        return books;
    }
}