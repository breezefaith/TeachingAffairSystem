package teaching.affair.system.model;

import java.util.List;

import org.hibernate.Transaction;

import teaching.affair.system.dao.CourseDAO;
import teaching.affair.system.dao.StudentDAO;
import teaching.affair.system.pojo.Course;
import teaching.affair.system.pojo.Student;

public class ManagerCourse {
	public static String getJsonString(){
		CourseDAO courseDAO=new CourseDAO();
		List<Course> courses=courseDAO.findAll();
		StringBuffer info=new StringBuffer("[");
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
	public static boolean updateCourse(String courseNo, String courseName, String courseAcademy,
			String courseCategory) {
		
		try {
			CourseDAO courseDAO=new CourseDAO();
			Transaction transaction=courseDAO.getSession().beginTransaction();
			Course course=new Course(courseNo, courseName, courseAcademy, courseCategory);
			System.out.println("开始更新");
			System.out.println(course);
			courseDAO.getSession().update(course);
			transaction.commit();
			System.out.println("更新成功");
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}
	public static boolean insertCourse(String courseNo, String courseName, String courseAcademy,
			String courseCategory) {
		try {
			CourseDAO courseDAO=new CourseDAO();
			Transaction transaction=courseDAO.getSession().beginTransaction();
			Course course=new Course(courseNo, courseName, courseAcademy, courseCategory);
			System.out.println("开始插入");
			System.out.println(course);
			courseDAO.getSession().save(course);
			transaction.commit();
			System.out.println("插入成功");
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}
	public static boolean deleteCourse(String courseNo) {
		try {
			CourseDAO courseDAO=new CourseDAO();
			Transaction transaction=courseDAO.getSession().beginTransaction();
			System.out.println("开始删除");
			Course course=courseDAO.findById(courseNo);
			System.out.println(course);
			if(course!=null){
				courseDAO.delete(course);
			}
			transaction.commit();
			System.out.println("删除成功");
			return true;
		} catch (RuntimeException e) {
			System.out.println("删除失败");
			return false;
		}
	}
	private static String formatString(String key,String value){
		return "\""+key+"\":"+"\""+value+"\",";
	}
	public static void main(String[] args) {
		deleteCourse("c5");
	}
}
