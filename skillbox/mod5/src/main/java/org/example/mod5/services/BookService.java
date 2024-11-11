package org.example.mod5.services;

import org.example.mod5.models.Book;
import org.example.mod5.models.Category;
import org.example.mod5.repositories.BookRepository;
import org.example.mod5.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Cacheable(value = "books", key = "#title + #author")
    public Book findBookByTitleAndAuthor(String title, String author) {
        return bookRepository.findByTitleAndAuthor(title, author).orElse(null);
    }

    @Cacheable(value = "booksByCategory", key = "#categoryName")
    public List<Book> findBooksByCategoryName(String categoryName) {
        return bookRepository.findByCategoryName(categoryName);
    }

    @CacheEvict(value = {"books", "booksByCategory"}, allEntries = true)
    public Book createBook(Book book) {
        Category category = categoryRepository.findByName(book.getCategory().getName())
                .orElseGet(() -> categoryRepository.save(book.getCategory()));
        book.setCategory(category);
        return bookRepository.save(book);
    }

    @CacheEvict(value = {"books", "booksByCategory"}, allEntries = true)
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    @CacheEvict(value = {"books", "booksByCategory"}, allEntries = true)
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}

