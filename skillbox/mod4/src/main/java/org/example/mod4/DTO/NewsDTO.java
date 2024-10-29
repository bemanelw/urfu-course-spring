package org.example.mod4.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class NewsDTO {
        private Long id;
        private String title;
        private String content;
        private UserDTO author;
        private CategoryDTO category;
        private int commentCount;
    }
