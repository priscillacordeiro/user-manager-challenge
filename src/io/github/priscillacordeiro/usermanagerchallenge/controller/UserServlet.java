package io.github.priscillacordeiro.usermanagerchallenge.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.priscillacordeiro.usermanagerchallenge.model.User;
import io.github.priscillacordeiro.usermanagerchallenge.service.UserService;

@WebServlet("/users/*")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();

		switch (action) {
		case "/new":
			showUserForm(request, response);
			break;
		case "/list":
			showUserList(request, response);
			break;
		case "/view":
			showUserView(request, response);
			break;
		case "/edit":
			showUserForm(request, response);
			break;
		case "/delete":
			deleteUser(request, response);
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();

		switch (action) {
		case "/create":
			createUser(request, response);
			break;
		case "/update":
			updateUser(request, response);
			break;
		}
	}
	
	private void createUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = new User(name, email, password);
		
		User savedUser = userService.getByEmail(email);
		
		if(savedUser == null) {
			userService.create(user);
			response.sendRedirect("list");
		} else {
			request.setAttribute("error", "E-mail already exists!");
			request.getRequestDispatcher("/pages/user-form.jsp").forward(request, response);
		}
		
	}

	private void showUserForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("id") != null) {
			Long id = Long.parseLong(request.getParameter("id"));
			User user = userService.getById(id);

			request.setAttribute("user", user);
		}
		request.getRequestDispatcher("/pages/user-form.jsp").forward(request, response);
	}

	private void showUserList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> listUser = userService.getAll();
		request.setAttribute("listUser", listUser);
		request.getRequestDispatcher("/pages/user-list.jsp").forward(request, response);
	}
	
	private void showUserView(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		User user = userService.getById(id);
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("/pages/user-view.jsp").forward(request, response);
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User formUser = new User(id, name, email, password);
		
		User emailUser = userService.getByEmail(email);
		User originalUser = userService.getById(id);
		
		if(originalUser.getEmail().equals(email) || emailUser == null) {
			userService.update(formUser);
			response.sendRedirect("view?id=" + id);
		} else {
			request.setAttribute("user", formUser);
			request.setAttribute("error", "E-mail already exists!");
			request.getRequestDispatcher("/pages/user-form.jsp").forward(request, response);
		}
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));	
		
		userService.delete(id);
		response.sendRedirect("list");	
	}
	
}