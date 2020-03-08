package io.github.priscillacordeiro.usermanagerchallenge.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.priscillacordeiro.usermanagerchallenge.model.Phone;
import io.github.priscillacordeiro.usermanagerchallenge.model.User;
import io.github.priscillacordeiro.usermanagerchallenge.service.PhoneService;

@WebServlet("/phones/*")
public class PhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PhoneService phoneService = new PhoneService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();

		switch (action) {
		case "/new":
			showPhoneForm(request, response);
			break;
		case "/edit":
			showPhoneForm(request, response);
			break;
		case "/delete":
			deletePhone(request, response);
			break;
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

	private void createPhone(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		int ddd = Integer.parseInt(request.getParameter("ddd"));
		String number = request.getParameter("number");
		String type = request.getParameter("type");
		Long userId = Long.parseLong(request.getParameter("userId"));
		
		User user = new User(userId);
		Phone phone = new Phone(ddd, number, type, user);
		
		phoneService.create(phone);
		
		response.sendRedirect(request.getContextPath() + "/users/view?id=" + userId);
	}
	
	private void showPhoneForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		if (request.getParameter("id") != null) {
			Long id = Long.parseLong(request.getParameter("id"));
			Phone phone = phoneService.getById(id);
			
			request.setAttribute("phone", phone);
		}
		
		Long userId = Long.parseLong(request.getParameter("userId"));
		
		request.setAttribute("userId", userId);
		request.getRequestDispatcher("/pages/phone-form.jsp").forward(request, response);
	}
	
	private void updatePhone(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		int ddd = Integer.parseInt(request.getParameter("ddd"));
		String number = request.getParameter("number");
		String type = request.getParameter("type");
		Long userId = Long.parseLong(request.getParameter("userId"));
		
		User user = new User(userId);
		Phone phone = new Phone(id, ddd, number, type, user);
		
		phoneService.update(phone);
		
		response.sendRedirect(request.getContextPath() + "/users/view?id=" + userId);
	}
	
	private void deletePhone(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Long userId = Long.parseLong(request.getParameter("userId"));
		Long id = Long.parseLong(request.getParameter("id"));	
		
		phoneService.delete(id);
		response.sendRedirect(request.getContextPath() + "/users/view?id=" + userId);
	}
	
}