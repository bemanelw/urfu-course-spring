package ru.chernyugov.springcourse.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import ru.chernyugov.springcourse.models.User;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
}
