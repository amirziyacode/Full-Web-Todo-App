package org.amirziya.todoweb.service;

import org.amirziya.todoweb.model.Todo;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class TodoServiceImpl implements TodoService {

    private final Map<UUID, Todo> todoMap;

    public TodoServiceImpl(){
        this.todoMap = new HashMap<>();
        Todo todo = Todo.builder()
                .id(UUID.randomUUID())
                .title("Personal")
                .description("This is Todo !")
                .build();

        Todo todo1 = Todo.builder()
                .id(UUID.randomUUID())
                .title("Sport")
                .description("Play Tennis")
                .build();

        Todo todo2 = Todo.builder()
                .id(UUID.randomUUID())
                .title("Study")
                .description("Learn Math !")
                .build();

        todoMap.put(todo.getId(),todo);
        todoMap.put(todo1.getId(),todo1);
        todoMap.put(todo2.getId(),todo2);
    }

    @Override
    public List<Todo> getAll() {
        return new ArrayList<>(todoMap.values());
    }

    @Override
    public Optional<Todo> getById(UUID id) {
        return Optional.ofNullable(todoMap.get(id));
    }

    @Override
    public Todo save(Todo todo) {
        Todo newTodo = Todo.builder()
                .id(UUID.randomUUID())
                .title(todo.getTitle())
                .description(todo.getDescription())
                .isDO(todo.isDO())
                .build();

        todoMap.put(todo.getId(),newTodo);
        return newTodo;
    }

    @Override
    public void update(UUID id, Todo upTodo) {
        Todo updateTodo = todoMap.get(id);
        updateTodo.setDescription(updateTodo.getDescription());
        updateTodo.setTitle(upTodo.getTitle());
        updateTodo.setDO(upTodo.isDO());
        todoMap.put(id,updateTodo);
    }

    @Override
    public void delete(UUID id) {
        todoMap.remove(id);
    }
}