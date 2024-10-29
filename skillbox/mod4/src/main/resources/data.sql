-- src/main/resources/data.sql
DELETE FROM comment;
DELETE FROM news;
DELETE FROM category;
DELETE FROM app_user;

-- Инициализация таблицы app_user
INSERT INTO app_user (id, username, password) VALUES (1, 'john_doe', 'password123');
INSERT INTO app_user (id, username, password) VALUES (2, 'jane_doe', 'password456');

-- Инициализация таблицы category
INSERT INTO category (id, name) VALUES (1, 'Technology');
INSERT INTO category (id, name) VALUES (2, 'Sports');

-- Инициализация таблицы news
INSERT INTO news (id, title, content, author_id, category_id) VALUES (1, 'New Technology Trends', 'This is a news about new technology trends.', 1, 1);
INSERT INTO news (id, title, content, author_id, category_id) VALUES (2, 'Sports Update', 'This is a news about the latest sports events.', 2, 2);

-- Инициализация таблицы comment
INSERT INTO comment (id, content, author_id, news_id) VALUES (1, 'This is a comment on the technology news.', 1, 1);
INSERT INTO comment (id, content, author_id, news_id) VALUES (2, 'This is a comment on the sports news.', 2, 2);
