package teaching.affair.system.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnectionUtil {
	private Connection connection;
	
	public ConnectionUtil() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public ResultSet executeQuery(String sql){
		ResultSet resultSet=null;
		try {
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/teaching_affair_management_system?useUnicode=true&characterEncoding=UTF-8", "root", "990524");
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			return resultSet;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean excuteUpdate(String sql){
		try {
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/teaching_affair_management_system?useUnicode=true&characterEncoding=UTF-8", "root", "990524");
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public void close(){
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ConnectionUtil connectionUtil=new ConnectionUtil();
		String sql="select * from select_course_result_view where teacher_no='t1'";
		ResultSet resultSet=null;
		try {
			resultSet=connectionUtil.executeQuery(sql);
			while(resultSet.next()){
				System.out.println(resultSet.getString("student_no"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
