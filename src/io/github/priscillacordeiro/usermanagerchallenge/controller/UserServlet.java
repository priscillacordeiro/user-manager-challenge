package io.github.priscillacordeiro.usermanagerchallenge.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.priscillacordeiro.usermanagerchallenge.model.User;
import io.github.priscillacordeiro.usermanagerchallenge.repository.UserRepository;

@WebServlet("/users/*")
public class UserServlet extends HttpServlet {

	private UserRepository userRepository = new UserRepository();

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

	private void showUserForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("id") != null) {
			Long id = Long.parseLong(request.getParameter("id"));
			User user = userRepository.getById(id);

			request.setAttribute("user", user);
		}
		request.getRequestDispatcher("/user-form.jsp").forward(request, response);
	}

	private void showUserList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> listUser = userRepository.getAll();
		request.setAttribute("listUser", listUser);
		request.getRequestDispatcher("/user-list.jsp").forward(request, response);
	}

	private void createUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		User user = new User(name, email, password);

		userRepository.create(user);

		response.sendRedirect("list");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = new User(id, name, email, password);

		userRepository.update(user);
		response.sendRedirect("list");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));	
		
		userRepository.delete(id);
		response.sendRedirect("list");	
	}
}