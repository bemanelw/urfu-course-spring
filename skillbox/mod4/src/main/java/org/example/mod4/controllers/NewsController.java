package org.example.mod4.controllers;

import jakarta.validation.Valid;
import org.example.mod4.DTO.NewsDTO;
import org.example.mod4.entities.Category;
import org.example.mod4.entities.News;
import org.example.mod4.entities.User;
import org.example.mod4.services.NewsService;
import org.example.mod4.specification.NewsSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/news")
public class NewsController {
    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @PostMapping
    public ResponseEntity<NewsDTO> createNews(@Valid @RequestBody NewsDTO newsDTO) {
        NewsDTO createdNews = newsService.createNews(newsDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNews);
    }

    @GetMapping
    public ResponseEntity<Page<NewsDTO>> getNews(
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) Long authorId,
            Pageable pageable) {
        Specification<News> specification = Specification.where(null);
        if (categoryId != null) {
            specification = specification.and(NewsSpecification.byCategory(new Category(categoryId)));
        }
        if (authorId != null) {
            specification = specification.and(NewsSpecification.byAuthor(new User(authorId)));
        }
        Page<NewsDTO> newsPage = newsService.getNews(pageable, specification);
        return ResponseEntity.ok(newsPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsDTO> getNewsById(@PathVariable Long id) {
        NewsDTO newsDTO = newsService.getNewsById(id);
        return ResponseEntity.ok(newsDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewsDTO> updateNews(@PathVariable Long id, @Valid @RequestBody NewsDTO newsDTO) {
        NewsDTO updatedNews = newsService.updateNews(id, newsDTO);
        return ResponseEntity.ok(updatedNews);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNews(@PathVariable Long id) {
        newsService.deleteNews(id);
        return ResponseEntity.noContent().build();
    }
}