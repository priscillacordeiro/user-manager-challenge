package io.github.priscillacordeiro.usermanagerchallenge.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.priscillacordeiro.usermanagerchallenge.model.Phone;
import io.github.priscillacordeiro.usermanagerchallenge.model.User;
import io.github.priscillacordeiro.usermanagerchallenge.repository.PhoneRepository;

@WebServlet("/phones/*")
public class PhoneServlet extends HttpServlet {
	
	private PhoneRepository phoneRepository = new PhoneRepository();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();

		switch (action) {
		case "/new":
			showPhoneForm(request, response);
			break;
		/*case "/list":
			showUserList(request, response);
			break;
		case "/edit":
			showUserForm(request, response);
			break;
		case "/delete":
			deleteUser(request, response);
			break;*/
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();

		switch (action) {
		case "/create":
			createPhone(request, response);
			break;
		case "/update":
			updatePhone(request, response);
			break;
		}
	}

	private void updatePhone(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
	}

	private void createPhone(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		int ddd = Integer.parseInt(request.getParameter("ddd"));
		String number = request.getParameter("number");
		String type = request.getParameter("type");
		Long userId = Long.parseLong(request.getParameter("userId"));
		
		User user = new User(userId);
		Phone phone = new Phone(ddd, number, type, user);
		
		phoneRepository.create(phone);
		
		response.sendRedirect("/user-manager-challenge/users/edit?id=" + userId);
	}

	private void showPhoneForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Long userId = Long.parseLong(request.getParameter("userId"));
		
		request.setAttribute("userId", userId);
		request.getRequestDispatcher("/phone-form.jsp").forward(request, response);
	}
	
}