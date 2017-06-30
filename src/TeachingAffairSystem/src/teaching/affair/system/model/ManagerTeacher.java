package teaching.affair.system.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import teaching.affair.system.dao.TeacherDAO;
import teaching.affair.system.pojo.Teacher;

public class ManagerTeacher{
	public static String getJsonString(){
		TeacherDAO teacherDAO=new TeacherDAO();
		List<Teacher> teachers=teacherDAO.findAll();
		StringBuffer teacherInfo=new StringBuffer("[");
		for(Teacher item:teachers){
			teacherInfo.append("{");
			teacherInfo.append(formatString("teacherNo", item.getTeacherNo()));
			teacherInfo.append(formatString("teacherName", item.getTeacherName()));
			teacherInfo.append(formatString("teacherAcademy", item.getTeacherAcademy()));
			teacherInfo.append(formatString("teacherTitle", item.getTeacherTitle()));
			teacherInfo.append(formatString("sex", item.getSex()));
			teacherInfo.append(formatString("teacherEmail", item.getTeacherEmail()));
			teacherInfo.append(formatString("password", item.getPassword()));
			teacherInfo.deleteCharAt(teacherInfo.length()-1);
			teacherInfo.append("},");
		}
		teacherInfo.deleteCharAt(teacherInfo.length()-1);
		teacherInfo.append("]");
		return new String(teacherInfo);
	}
	public static boolean updateTeacher(String teacherNo,String teacherName,String sex,String teacherAcademy,String teacherTitle,String teacherEmail,String password){
		try {
			TeacherDAO teacherDAO=new TeacherDAO();
			Transaction transaction=teacherDAO.getSession().beginTransaction();
			Teacher teacher=new Teacher(teacherNo, teacherName, sex, teacherAcademy, teacherTitle, teacherEmail, password);
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
//	public static void main(String[] args) {
//		System.out.println(getJsonString());
//	}
	public static boolean insertTeacher(String teacherNo, String teacherName, String sex, String teacherAcademy,
			String teacherTitle, String teacherEmail, String password) {
		try {
			TeacherDAO teacherDAO=new TeacherDAO();
			Transaction transaction=teacherDAO.getSession().beginTransaction();
			Teacher teacher=new Teacher(teacherNo, teacherName, sex, teacherAcademy, teacherTitle, teacherEmail, password);
			System.out.println("开始插入");
			System.out.println(teacher);
			teacherDAO.getSession().save(teacher);
			transaction.commit();
			System.out.println("插入成功");
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}
	public static boolean deleteTeacher(String teacherNo) {
		try {
			TeacherDAO teacherDAO=new TeacherDAO();
			Transaction transaction=teacherDAO.getSession().beginTransaction();
//			Teacher teacher=new Teacher(teacherNo, teacherName, sex, teacherAcademy, teacherTitle, teacherEmail, password);
			System.out.println("开始删除");
			teacherDAO.delete(new Teacher(teacherNo));;
			transaction.commit();
			System.out.println("删除成功");
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}
}
