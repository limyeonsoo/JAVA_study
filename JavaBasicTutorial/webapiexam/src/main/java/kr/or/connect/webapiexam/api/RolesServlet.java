package kr.or.connect.webapiexam.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.connect.jdbcExam.dao.RoleDao;
import kr.or.connect.jdbcExam.dto.Role;

@WebServlet("/roles")
public class RolesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RolesServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");   // json 형태로 

		RoleDao dao = new RoleDao();

		List<Role> list = dao.getRoles();

		ObjectMapper objectMapper = new ObjectMapper();      // JSON 문자열을 객체로 바꿔줌.
		String json = objectMapper.writeValueAsString(list);   // 해당 문자열이 JSON으로 바뀜.

		PrintWriter out = response.getWriter();
		out.println(json);                                     //응답결과
		out.close();
	}

}