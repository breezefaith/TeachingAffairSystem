package teaching.affair.system.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Transaction;

import teaching.affair.system.dao.SelectCourseDAO;
import teaching.affair.system.dao.SelectCourseResultViewDAO;
import teaching.affair.system.dao.SelectedCourseViewDAO;
import teaching.affair.system.pojo.SelectCourse;
import teaching.affair.system.pojo.view.SelectCourseResultView;
import teaching.affair.system.pojo.view.SelectedCourseView;
import teaching.affair.system.util.ConnectionUtil;

public class StudentCourse {

	public static boolean insertSelectCourse(String semesterNo, String studentNo, String courseNo) {
		try {
			SelectCourseDAO selectCourseDAO=new SelectCourseDAO();
			Transaction transaction=selectCourseDAO.getSession().beginTransaction();
			String sql="insert into select_course(student_no,semester_course_no) "
					+ "select '"+studentNo+"',semester_course_no "
							+ "from semester_course "
							+ "where semester_no='"+semesterNo+"' "
									+ "and course_no='"+courseNo+"'";
			SQLQuery<SelectCourse> sqlQuery=selectCourseDAO.getSession().createSQLQuery(sql);
			sqlQuery.executeUpdate();
			transaction.commit();
			System.out.println("插入成功");
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}
	public static boolean removeSelectCourse(String semesterNo, String studentNo, String courseNo) {
		try {
			SelectCourseDAO selectCourseDAO=new SelectCourseDAO();
			Transaction transaction=selectCourseDAO.getSession().beginTransaction();
			String sql="delete from select_course where student_no='"+studentNo+"' "
					+ "and semester_course_no in (select semester_course_no from semester_course "
					+ "where semester_no='"+semesterNo+"' and course_no='"+courseNo+"')";
			SQLQuery<SelectCourse> sqlQuery=selectCourseDAO.getSession().createSQLQuery(sql);
			sqlQuery.executeUpdate();
			transaction.commit();
			System.out.println("删除成功");
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}
	public static String getSelectedCourseJsonString(String studentNo) {
		StringBuffer info=new StringBuffer("[");
		SelectedCourseViewDAO selectedCourseViewDAO=new SelectedCourseViewDAO();
		String sql="select * from selected_course_view where is_current_semester=1 "
				+ "and course_no not in (select course_no from select_course_result_view "
				+ "where student_no='"+studentNo+"')";
		SQLQuery<SelectedCourseView> sqlQuery=selectedCourseViewDAO.getSession().createSQLQuery(sql);
		sqlQuery.addEntity(SelectedCourseView.class);
		List<SelectedCourseView> list=sqlQuery.getResultList();
		for(SelectedCourseView item:list){
			info.append("{");
			info.append(formatString("courseNo", item.getId().getCourseNo()));
			info.append(formatString("courseName", item.getId().getCourseName()));
			info.append(formatString("courseAcademy", item.getId().getCourseAcademy()));
			info.append(formatString("courseCategory", item.getId().getCourseCategory()));
			info.append(formatString("teacherNo", item.getId().getTeacherNo()));
			info.append(formatString("teacherName", item.getId().getTeacherName()));
			info.append(formatString("teacherAcademy", item.getId().getTeacherAcademy()));
			info.append(formatString("teacherTitle", item.getId().getTeacherTitle()));
			info.append(formatString("email", item.getId().getTeacherEmail()));
			info.append(formatString("semesterNo", item.getId().getSemesterNo().toString()));
			info.append(formatString("semesterName", item.getId().getSemesterName()));
			info.append(formatString("startWeek", item.getId().getStartWeek().toString()));
			info.append(formatString("endWeek", item.getId().getEndWeek().toString()));
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
	public static String getStudentCourseJsonString(String studentNo) {
		StringBuffer info=new StringBuffer("[");
		String sql="select * from select_course_result_view where student_no='"+studentNo+"' "
				+ "and semester_no = (select semester_no from current_semester)";
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
				if(resultSet.getString("score")==null){
					info.append(formatString("score",""));
				}else{
					info.append(formatString("score",resultSet.getString("score")));
				}
				info.deleteCharAt(info.length()-1);
				info.append("},");
			}
			info.deleteCharAt(info.length()-1);
			info.append("]");
			return new String(info);
		} catch (SQLException e) {
			e.printStackTrace();
			return "[]";
		}
	}
	public static void main(String[] args) {
		System.out.println(getStudentCourseJsonString("s2"));
	}
}
