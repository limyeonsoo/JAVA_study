package kr.or.connect.jdbcExam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.connect.jdbcExam.dto.Role;

public class RoleDao {
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb";
	private static String dbUser = "connectuser";
	private static String dbpasswd = "connect123!@#";
	
	//데이터 한 건 가져오기.
	public Role getRole(Integer roleId) {
		Role role = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");  //Driver가 loading되어 Memory로 가게 해줌.
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			String sql = "SELECT role_id, description FROM role WHERE role_id = ?"; //물음표에 대한 값의 변경에 따르기 때문에 효율적일 수 있음.
			ps = conn.prepareStatement(sql);
			ps.setInt(1,  roleId);;
			rs = ps.executeQuery();
			
			if(rs.next()) {  //rs 결과물의 커서를 next로 옮기고 값이 있을 땐 true 반환
				String description = rs.getString(2);         // query문의 순서를 줘도 됨.
				int id = rs.getInt("role_id");    // column 이름을 입력해도 되고
				role = new Role(id, description);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {   //닫는건 무조건 실행
			if(rs != null) { // ps에서 끝나면 rs 는 null -> null pointer exception 을 빼버리기
				try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return role;
	}
	
	// 데이터 추가하기
	public int addRole(Role role) {
		int insertCount = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "INSERT INTO role (role_id, description) VALUES ( ?, ? )";

		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, role.getRoleId());
			ps.setString(2, role.getDescription());

			insertCount = ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return insertCount;
	}
	
	//전체 조회하기
	public List<Role> getRoles() {
		List<Role> list = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String sql = "SELECT description, role_id FROM role order by role_id desc";
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					String description = rs.getString(1);
					int id = rs.getInt("role_id");
					Role role = new Role(id, description);
					list.add(role); // list에 반복할때마다 Role인스턴스를 생성하여 list에 추가한다.
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
	
	//삭제
	public int deleteRole(Integer roleId) {
		int deleteCount = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName( "com.mysql.jdbc.Driver" );
			
			conn = DriverManager.getConnection ( dburl, dbUser, dbpasswd );
			
			String sql = "DELETE FROM role WHERE role_id = ?";

			ps = conn.prepareStatement(sql);
			
			ps.setInt(1,  roleId);

			deleteCount = ps.executeUpdate();

		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch(Exception ex) {}
			} // if
			
			if(conn != null) {
				try {
					conn.close();
				}catch(Exception ex) {}
			} // if
		} // finally

		return deleteCount;
	}
	
	//업데이트
	public int updateRole(Role role) {
		int updateCount = 0;
		
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName( "com.mysql.jdbc.Driver" );
			
			conn = DriverManager.getConnection ( dburl, dbUser, dbpasswd );
			
			String sql = "update role set description = ? where role_id = ?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, role.getDescription());
			ps.setInt(2,  role.getRoleId());
			
			updateCount = ps.executeUpdate();

		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch(Exception ex) {}
			} // if
			
			if(conn != null) {
				try {
					conn.close();
				}catch(Exception ex) {}
			} // if
		} // finally
		
		return updateCount;
	}
}
