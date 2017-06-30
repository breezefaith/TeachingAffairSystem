package teaching.affair.system.model;

import java.util.List;

import org.hibernate.Transaction;

import teaching.affair.system.dao.SemesterCourseDAO;
import teaching.affair.system.pojo.SemesterCourse;

public class ManagerSemesterCourse {

	public static boolean insertSemesterCourse(String semesterNo, String courseNo, String teacherNo, String startWeek,
			String endWeek, String expectNum) {
		try{
			SemesterCourseDAO semesterCourseDAO=new SemesterCourseDAO();
			System.out.println("开始插入");
			Transaction transaction=semesterCourseDAO.getSession().beginTransaction();
			SemesterCourse semesterCourse=new SemesterCourse(Integer.valueOf(semesterNo), courseNo, teacherNo, Integer.valueOf(startWeek), Integer.valueOf(endWeek), Integer.valueOf(expectNum));
			semesterCourseDAO.getSession().save(semesterCourse);
			transaction.commit();
			System.out.println("插入成功");
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}

	public static boolean updateSemesterCourse(String semesterNo, String courseNo, String teacherNo, String startWeek,
			String endWeek, String expectNum) {
		try{
			SemesterCourseDAO semesterCourseDAO=new SemesterCourseDAO();
			System.out.println("开始更新");
			Transaction transaction=semesterCourseDAO.getSession().beginTransaction();
			SemesterCourse semesterCourse=new SemesterCourse(Integer.valueOf(semesterNo), courseNo, teacherNo, Integer.valueOf(startWeek), Integer.valueOf(endWeek), Integer.valueOf(expectNum));
			semesterCourseDAO.getSession().update(semesterCourse);
			transaction.commit();
			System.out.println("更新成功");
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public static boolean deleteSemesterCourse(String semesterNo, String courseNo, String teacherNo, String startWeek,String endWeek,
			String expectNum) {
		try{
			SemesterCourseDAO semesterCourseDAO=new SemesterCourseDAO();
			System.out.println("开始删除");
			Transaction transaction=semesterCourseDAO.getSession().beginTransaction();
			SemesterCourse semesterCourse=new SemesterCourse(Integer.valueOf(semesterNo), courseNo, teacherNo, Integer.valueOf(startWeek), Integer.valueOf(endWeek), Integer.valueOf(expectNum));
			List<SemesterCourse> list=semesterCourseDAO.findByExample(semesterCourse);
			System.out.println(list.size());
			for(SemesterCourse item:list){
				semesterCourse=item;
				break;
			}
			System.out.println(semesterCourse);
			semesterCourseDAO.delete(semesterCourse);
			transaction.commit();
			System.out.println("删除成功");
			return true;
		}catch (Exception e) {
			return false;
		}
	}

}
