package teaching.affair.system.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import teaching.affair.system.util.ConnectionUtil;

public class TeacherCourse {

	public static String getJsonString(String teacherNo) {
		StringBuffer info=new StringBuffer("[");
		String sql="select * from select_course_result_view where teacher_no='"+teacherNo+"' ";
		ConnectionUtil connectionUtil=new ConnectionUtil();
		ResultSet resultSet=null;
		resultSet=connectionUtil.executeQuery(sql);
		try {
			while(resultSet.next()){
				info.append("{");
				info.append(formatString("studentNo",resultSet.getString("student_no")));
				info.append(formatString("studentName",resultSet.getString("student_name")));
				info.append(formatString("studentAcademy",resultSet.getString("student_academy")));
				info.append(formatString("studentMajor",resultSet.getString("student_major")));
				info.append(formatString("studentClass",resultSet.getString("student_class")));
				info.append(formatString("teacherNo",resultSet.getString("teacher_no")));
				info.append(formatString("teacherName",resultSet.getString("teacher_name")));
				info.append(formatString("teacherAcademy",resultSet.getString("teacher_academy")));
				info.append(formatString("teacherTitle",resultSet.getString("teacher_title")));
				info.append(formatString("email",resultSet.getString("teacher_email")));
				info.append(formatString("courseNo",resultSet.getString("course_no")));
				info.append(formatString("courseName",resultSet.getString("course_name")));
				info.append(formatString("courseAcademy",resultSet.getString("course_academy")));
				info.append(formatString("courseCategory",resultSet.getString("course_category")));
				info.append(formatString("startWeek",resultSet.getString("start_week")));
				info.append(formatString("endWeek",resultSet.getString("end_week")));
				info.append(formatString("semesterNo",resultSet.getString("semester_no")));
				info.append(formatString("semesterName",resultSet.getString("semester_name")));
				info.append(formatString("score",resultSet.getString("score")));
				info.deleteCharAt(info.length()-1);
				info.append("},");
			}
			info.deleteCharAt(info.length()-1);
			info.append("]");
			return new String(info);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "[]";
		}
		
	}
	private static String formatString(String key,String value){
		return "\""+key+"\":"+"\""+value+"\",";
	}
	public static void main(String[] args) {
		System.out.println(getJsonString("t2"));
	}
}
