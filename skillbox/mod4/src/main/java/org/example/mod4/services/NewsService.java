package org.example.mod4.services;

import org.example.mod4.DTO.NewsDTO;
import org.example.mod4.entities.News;
import org.example.mod4.mappers.NewsMapper;
import org.example.mod4.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class NewsService {
    private final NewsRepository newsRepository;
    private final NewsMapper newsMapper;

    @Autowired
    public NewsService(NewsRepository newsRepository, NewsMapper newsMapper) {
        this.newsRepository = newsRepository;
        this.newsMapper = newsMapper;
    }

    public NewsDTO createNews(NewsDTO newsDTO) {
        News news = newsMapper.toEntity(newsDTO);
        News savedNews = newsRepository.save(news);
        return newsMapper.toDto(savedNews);
    }

    public Page<NewsDTO> getNews(Pageable pageable, Specification<News> specification) {
        Page<News> newsPage = newsRepository.findAll(specification, pageable);
        return newsPage.map(newsMapper::toDto);
    }

    public NewsDTO getNewsById(Long id) {
        News news = newsRepository.findById(id).orElseThrow(() -> new RuntimeException("News not found"));
        return newsMapper.toDto(news);
    }

    public NewsDTO updateNews(Long id, NewsDTO newsDTO) {
        News news = newsRepository.findById(id).orElseThrow(() -> new RuntimeException("News not found"));
        news.setTitle(newsDTO.getTitle());
        news.setContent(newsDTO.getContent());
        News updatedNews = newsRepository.save(news);
        return newsMapper.toDto(updatedNews);
    }

    public void deleteNews(Long id) {
        newsRepository.deleteById(id);
    }
}
