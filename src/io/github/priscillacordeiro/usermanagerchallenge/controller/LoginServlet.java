package io.github.priscillacordeiro.usermanagerchallenge.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import io.github.priscillacordeiro.usermanagerchallenge.model.User;
import io.github.priscillacordeiro.usermanagerchallenge.repository.UserRepository;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserRepository userRepository = new UserRepository();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("/pages/login-form.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = userRepository.getByEmail(email);
		
		if(user != null && password.equals(user.getPassword())) {
			HttpSession session = request.getSession();
			session.setAttribute("name", user.getName());
			response.sendRedirect(request.getContextPath() + "/users/list");
		} else {
			request.setAttribute("error", "E-mail or password invalid!");
			request.getRequestDispatcher("/pages/login-form.jsp").forward(request, response);
		}
	}

}