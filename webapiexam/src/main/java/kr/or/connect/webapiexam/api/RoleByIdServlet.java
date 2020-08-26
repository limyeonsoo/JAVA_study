package kr.or.connect.webapiexam.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.connect.jdbcExam.dao.RoleDao;
import kr.or.connect.jdbcExam.dto.Role;

@WebServlet("/roles/*")
public class RoleByIdServlet extends HttpServlet {    // ID를 쿼리로 사용하여 해당 ID 조회
	private static final long serialVersionUID = 1L;

	public RoleByIdServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		String pathInfo = request.getPathInfo(); // /roles/{roleId}  roles : 1  roleId : 2
		String[] pathParts = pathInfo.split("/");
		String idStr = pathParts[1];           // roles
		int id = Integer.parseInt(idStr);    //id를  int값으로 바꿈.

		RoleDao dao = new RoleDao();

		Role role = dao.getRole(id);

		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(role);  

		PrintWriter out = response.getWriter();
		out.println(json);
		out.close();
	}

}