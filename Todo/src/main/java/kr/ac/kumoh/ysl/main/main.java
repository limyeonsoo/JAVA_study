package kr.ac.kumoh.ysl.main;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

public class main extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html;charset=euc-kr");
		
		RequestDispatcher requestDispatcher;
		requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/main.jsp");
		requestDispatcher.forward(req, res);
	}
}