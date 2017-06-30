package teaching.affair.system.model;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.struts2.util.DateFormatter;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import teaching.affair.system.dao.CurrentSemesterDAO;
import teaching.affair.system.dao.ManagerDAO;
import teaching.affair.system.dao.SemesterCourseViewDAO;
import teaching.affair.system.dao.SemesterDAO;
import teaching.affair.system.dao.StudentDAO;
import teaching.affair.system.pojo.Semester;
import teaching.affair.system.pojo.Student;
import teaching.affair.system.pojo.view.SemesterCourseView;

public class ManagerSemester {
	public static String getJsonString(){
		SemesterCourseViewDAO semesterCourseViewDAO=new SemesterCourseViewDAO();
		List<SemesterCourseView> semesterCourseViews=semesterCourseViewDAO.findAll();
		StringBuffer info=new StringBuffer("[");
		for(SemesterCourseView item:semesterCourseViews){
			info.append("{");
			info.append(formatString("semesterNo", item.getId().getSemesterNo().toString()));
			info.append(formatString("semesterName", item.getId().getSemesterName()));
			info.append(formatString("semesterStartTime", item.getId().getStartDate().toString()));
			info.append(formatString("semesterEndTime", item.getId().getEndDate().toString()));
			info.append(formatString("courseNo", item.getId().getCourseNo()));
			info.append(formatString("courseName", item.getId().getCourseName()));
			info.append(formatString("courseAcademy", item.getId().getCourseAcademy()));
			info.append(formatString("courseCategory", item.getId().getCourseCategory()));
			info.append(formatString("teacherNo", item.getId().getTeacherNo()));
			info.append(formatString("teacherName", item.getId().getTeacherName()));
			info.append(formatString("teacherAcademy", item.getId().getTeacherAcademy()));
			info.append(formatString("teacherTitle", item.getId().getTeacherTitle()));
			info.append(formatString("teacherEmail", item.getId().getTeacherEmail()));
			info.append(formatString("startWeek", item.getId().getStartWeek().toString()));
			info.append(formatString("endWeek", item.getId().getEndWeek().toString()));
			info.append(formatString("expectNum", item.getId().getExpectNum().toString()));
			info.append(formatString("actualNum", String.valueOf(item.getId().getActualNum())));
			info.deleteCharAt(info.length()-1);
			info.append("},");
		}
		info.deleteCharAt(info.length()-1);
		info.append("]");
		return new String(info);
	}
	public static boolean deleteStudent(String studentNo) {
		try {
			StudentDAO studentDAO=new StudentDAO();
			Transaction transaction=studentDAO.getSession().beginTransaction();
			System.out.println("开始删除");
			Student student=studentDAO.findById(studentNo);
			if(student!=null){
				studentDAO.delete(student);
			}
			transaction.commit();
			System.out.println("删除成功");
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}
	public static boolean updateSemester(String semesterNo, String semesterName, String startTime, String endTime) {
		try {
			SemesterDAO semesterDAO=new SemesterDAO();
			Transaction transaction=semesterDAO.getSession().beginTransaction();
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-mm-dd");
			Semester semester=new Semester(semesterName, simpleDateFormat.parse(startTime), simpleDateFormat.parse(endTime));
			semester.setSemesterNo(Integer.valueOf(semesterNo));
			System.out.println("开始更新或插入");
			System.out.println(semester);
			if(semesterDAO.findById(Integer.valueOf(semesterNo))==null){
				System.out.println("插入");
				semesterDAO.getSession().save(semester);
			}else{
				System.out.println("更新");
				semesterDAO.getSession().update(semester);
			}
			transaction.commit();
			System.out.println("插入更新成功");
			return true;
		} catch (RuntimeException | ParseException e) {
			return false;
		}
	}
	public static boolean insertSemester(String semesterNo, String semesterName, String startTime, String endTime) {
		try {
			SemesterDAO semesterDAO=new SemesterDAO();
			Transaction transaction=semesterDAO.getSession().beginTransaction();
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-mm-dd");
			Semester semester=new Semester(semesterName, simpleDateFormat.parse(startTime), simpleDateFormat.parse(endTime));
			semester.setSemesterNo(Integer.valueOf(semesterNo));
			System.out.println("开始插入");
			System.out.println(semester);
			semesterDAO.getSession().save(semester);
			transaction.commit();
			System.out.println("插入成功");
			return true;
		} catch (RuntimeException | ParseException e) {
			return false;
		}
	}
	public static boolean deleteSemester(String semesterNo) {
		try {
			SemesterDAO semesterDAO=new SemesterDAO();
			Transaction transaction=semesterDAO.getSession().beginTransaction();
			System.out.println("开始删除");
			Semester semester=semesterDAO.findById(Integer.valueOf(semesterNo));
			if(semester!=null){
				semesterDAO.delete(semester);
			}
			transaction.commit();
			System.out.println("删除成功");
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}
	private static String formatString(String key,String value){
		return "\""+key+"\":"+"\""+value+"\",";
	}
	public static void main(String[] args) {
		SemesterDAO semesterDAO=new SemesterDAO();
		Transaction transaction=semesterDAO.getSession().beginTransaction();
		Semester semester=new Semester("2010", new java.util.Date(), new java.util.Date());
		semester.setSemesterNo(4);
		if(semesterDAO.findById(4)==null){
			semesterDAO.getSession().save(semester);
		}else{
			semesterDAO.getSession().update(semester);
		}
		transaction.commit();
		
	}
	public static boolean setCurrentSemester(String semesterNo) {
		try{
			CurrentSemesterDAO currentSemesterDAO=new CurrentSemesterDAO();
			System.out.println("开始更新");
			Transaction transaction=currentSemesterDAO.getSession().beginTransaction();
			SQLQuery sqlQuery=currentSemesterDAO.getSession().createSQLQuery("update current_semester set semester_no='"+semesterNo+"'");
			sqlQuery.executeUpdate();
			transaction.commit();
			System.out.println("更新成功");
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}
}
