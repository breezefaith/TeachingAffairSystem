package teaching.affair.system.model;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import teaching.affair.system.dao.CourseDAO;
import teaching.affair.system.pojo.Course;

public class ManagerCourseOption {
	public static String getJsonString(String semesterNo){
		StringBuffer info=new StringBuffer("[");
		CourseDAO courseDAO=new CourseDAO();
		Session session=courseDAO.getSession();
		String sql="select * from course where course_no not in(select course_no from semester_course_view where semester_no='"+semesterNo+"')";
		SQLQuery<Course> sqlQuery=session.createSQLQuery(sql);
		sqlQuery.addEntity(Course.class);
		List<Course> courses=sqlQuery.getResultList();
		for(Course item:courses){
			info.append("{");
			info.append(formatString("courseNo", item.getCourseNo()));
			info.append(formatString("courseName", item.getCourseName()));
			info.append(formatString("courseAcademy", item.getCourseAcademy()));
			info.append(formatString("courseCategory", item.getCourseCategory()));
			info.deleteCharAt(info.length()-1);
			info.append("},");
		}
		info.deleteCharAt(info.length()-1);
		info.append("]");
		return new String(info);
	}
	private static String formatString(String key,String value){
		return "\""+key+"\":"+"\""+value+"\",";
	}
	public static void main(String[] args) {
		CourseDAO courseDAO=new CourseDAO();
		Session session=courseDAO.getSession();
		String sql="select * from course where course_no not in(select course_no from semester_course_view where semester_no='1')";
		SQLQuery<Course> sqlQuery=session.createSQLQuery(sql);
		sqlQuery.addEntity(Course.class);
		List<Course> courses=sqlQuery.getResultList();
		for(Course item:courses){
			System.out.println(item);
		}
	}
}
