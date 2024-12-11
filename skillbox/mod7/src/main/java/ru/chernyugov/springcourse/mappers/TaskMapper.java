package ru.chernyugov.springcourse.mappers;

import ru.chernyugov.springcourse.dto.TaskDto;
import ru.chernyugov.springcourse.dto.UserDto;
import ru.chernyugov.springcourse.models.Task;
import ru.chernyugov.springcourse.models.User;

public interface TaskMapper {
    Task toTask(TaskDto taskDto);
    TaskDto toTaskDto(Task task);

    User toUser(UserDto userDto);
    UserDto toUserDto(User user);
}

