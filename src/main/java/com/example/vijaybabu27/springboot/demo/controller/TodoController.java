package com.example.vijaybabu27.springboot.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.vijaybabu27.springboot.demo.model.Todo;
import com.example.vijaybabu27.springboot.demo.service.LoginService;
import com.example.vijaybabu27.springboot.demo.service.TodoService;

@Controller
public class TodoController {
	
	@Autowired
	TodoService todoService;
	
	@Autowired
	LoginService loginService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}
	
	@RequestMapping (value="/list-todos", method = RequestMethod.GET)
	public String showTodosList(ModelMap model) {
		String user = loginService.getLoggedInUserName();
		model.put("todos", todoService.retriveTodos(user));
		return "list-todos";
	}

	@RequestMapping (value="/add-todo", method = RequestMethod.GET)
	public String showAddToDoPage(ModelMap model) {
		String user = loginService.getLoggedInUserName();
		model.addAttribute(new Todo(0, user, "", new Date(), false));
		return "add-todo";
	}
	
	@RequestMapping (value="/add-todo", method = RequestMethod.POST)
	public String addTodoToList(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "add-todo";
		}
		
		String user = loginService.getLoggedInUserName();
		todoService.addTodo(user, todo.getDesc(), new Date(), false);
		return "redirect:/list-todos";
	}
	
	@RequestMapping (value="/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		
		if(id == 1) {
			throw new RuntimeException();
		}
		
		todoService.deleteTodo(id);
		return "redirect:/list-todos";
	}
	
	@RequestMapping (value="/update-todo", method = RequestMethod.GET)
	public String updateTodo(ModelMap model, @RequestParam int id) {
		Todo todo = todoService.retriveTodoById(id);
		model.put("todo", todo);
		return "add-todo";
	}
	
	@RequestMapping (value="/update-todo", method = RequestMethod.POST)
	public String updateTodoById(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "update-todo";
		}
		
		todo.setUser(loginService.getLoggedInUserName());
		todoService.updateTodo(todo);
		return "redirect:/list-todos";
	}

}
