package teaching.affair.system.model;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import teaching.affair.system.dao.CourseDAO;
import teaching.affair.system.dao.TeacherDAO;
import teaching.affair.system.pojo.Course;
import teaching.affair.system.pojo.Teacher;

public class ManagerTeacherOption {
	public static String getJsonString(String semesterNo){
		StringBuffer info=new StringBuffer("[");
		TeacherDAO teacherDAO=new TeacherDAO();
		Session session=teacherDAO.getSession();
		String sql="select * from teacher where teacher_no not in(select teacher_no from semester_course_view where semester_no='"+semesterNo+"')";
		SQLQuery<Teacher> sqlQuery=session.createSQLQuery(sql);
		sqlQuery.addEntity(Teacher.class);
		List<Teacher> teachers=sqlQuery.getResultList();
		for(Teacher item:teachers){
			info.append("{");
			info.append(formatString("teacherNo", item.getTeacherNo()));
			info.append(formatString("teacherName", item.getTeacherName()));
			info.append(formatString("teacherAcademy", item.getTeacherAcademy()));
			info.append(formatString("teacherTitle", item.getTeacherTitle()));
			info.append(formatString("sex", item.getSex()));
			info.append(formatString("teacherEmail", item.getTeacherEmail()));
			info.append(formatString("password", item.getPassword()));
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
		System.out.println(getJsonString("1"));
	}
}
