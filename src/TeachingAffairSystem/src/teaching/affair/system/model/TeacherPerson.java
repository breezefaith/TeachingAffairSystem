package teaching.affair.system.model;

import org.hibernate.Transaction;

import teaching.affair.system.dao.StudentDAO;
import teaching.affair.system.dao.TeacherDAO;
import teaching.affair.system.pojo.Student;
import teaching.affair.system.pojo.Teacher;

public class TeacherPerson {
	public static String getJsonString(String teacherNo) {
		StringBuffer info=new StringBuffer("{");
		TeacherDAO teacherDAO=new TeacherDAO();
		Teacher teacher=teacherDAO.findById(teacherNo);
		info.append(formatString("teacherNo", teacher.getTeacherNo()));
		info.append(formatString("teacherName", teacher.getTeacherName()));
		info.append(formatString("sex",teacher.getSex()));
		info.append(formatString("teacherAcademy",teacher.getTeacherAcademy()));
		info.append(formatString("teacherTitle", teacher.getTeacherTitle()));
		info.append(formatString("email", teacher.getTeacherEmail()));
		info.append(formatString("password", teacher.getPassword()));
		info.deleteCharAt(info.length()-1);
		info.append("}");
		return new String(info);
	}
	public static boolean updateStudentPerson(String teacherNo, String teacherName, String sex, String teacherAcademy,
			String teacherTitle, String email, String password) {
		try {
			TeacherDAO teacherDAO=new TeacherDAO();
			Transaction transaction=teacherDAO.getSession().beginTransaction();
			Teacher teacher=new Teacher(teacherNo, teacherName, sex, teacherAcademy, teacherTitle, email, password);
			System.out.println("开始更新");
			System.out.println(teacher);
			teacherDAO.getSession().update(teacher);
			transaction.commit();
			System.out.println("更新成功");
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}
	private static String formatString(String key,String value){
		return "\""+key+"\":"+"\""+value+"\",";
	}
}
