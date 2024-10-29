package org.example.mod4.specification;

import org.example.mod4.entities.Category;
import org.example.mod4.entities.News;
import org.example.mod4.entities.User;
import org.springframework.data.jpa.domain.Specification;

public class NewsSpecification {
    public static Specification<News> byCategory(Category category) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("category"), category);
    }

    public static Specification<News> byAuthor(User author) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("author"), author);
    }
}
