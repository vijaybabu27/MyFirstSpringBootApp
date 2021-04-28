package com.example.vijaybabu27.springboot.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.vijaybabu27.springboot.demo.model.Todo;

@Service
public class TodoService {
	
	private static List<Todo> todos = new ArrayList<>();
	private static int todoCount = 3;
	
	static {
		todos.add(new Todo(1, "Vijay", "Study Spring Boot", new Date(), false));
		todos.add(new Todo(2, "Vijay", "Study Spring Boot", new Date(), false));
		todos.add(new Todo(3, "Vijay", "Study Spring Boot", new Date(), false));
	}
	
	public List<Todo> retriveTodos(String user) {
		List<Todo> userTodos = new ArrayList<>();
		for (Todo todo: todos) {
			if (todo.getUser().equalsIgnoreCase(user)) {
				userTodos.add(todo);
			}
		}
		
		return userTodos;
	}
	
	public Todo retriveTodoById(int id) {
		
		for (Todo todo: todos) {
			if (todo.getId() == id) {
				return todo;
			}
		}
		
		return null;
	}
	
	public void addTodo(String user, String desc, Date targetDate, boolean done) {
		todos.add(new Todo(++todoCount, user, desc, targetDate, done));
	}
	
	public void deleteTodo(int id) {
		Iterator<Todo> iterator = todos.iterator();
		while(iterator.hasNext()) {
			Todo todo = iterator.next();
			if(todo.getId() == id) {
				iterator.remove();
			}
		}
	}
	
	public void updateTodo(Todo todo) {
		todos.remove(todo);
		todos.add(todo);
	}

}
