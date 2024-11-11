package org.example.mod5.controllers;

import org.example.mod5.models.Book;
import org.example.mod5.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/find")
    public ResponseEntity<Book> findBookByTitleAndAuthor(@RequestParam String title, @RequestParam String author) {
        Book book = bookService.findBookByTitleAndAuthor(title, author);
        return book != null ? ResponseEntity.ok(book) : ResponseEntity.notFound().build();
    }

    @GetMapping("/category")
    public ResponseEntity<List<Book>> findBooksByCategoryName(@RequestParam String categoryName) {
        List<Book> books = bookService.findBooksByCategoryName(categoryName);
        return books.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(books);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book createdBook = bookService.createBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        Book updatedBook = bookService.updateBook(book);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}

