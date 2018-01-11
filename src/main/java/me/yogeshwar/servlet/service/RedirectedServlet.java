package me.yogeshwar.servlet.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet implementation class RedirectedServlet
 */
public class RedirectedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter writer = res.getWriter();
		writer.println("servlet request data: servlet: " + req.getAttribute("somedata"));
		writer.println("session data: servlet: " + ((HttpServletRequest)req).getSession().getAttribute("sessionData"));
		writer.println("current servlet: " + getServletName());
		writer.flush();
	}

}
