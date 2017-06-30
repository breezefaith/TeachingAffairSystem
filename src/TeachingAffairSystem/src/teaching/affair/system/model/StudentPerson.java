package teaching.affair.system.model;

import org.hibernate.Transaction;

import teaching.affair.system.dao.StudentDAO;
import teaching.affair.system.pojo.Student;

public class StudentPerson {

	public static String getJsonString(String studentNo) {
		StringBuffer info=new StringBuffer("{");
		StudentDAO studentDAO=new StudentDAO();
		Student student=studentDAO.findById(studentNo);
		info.append(formatString("studentNo", student.getStudentNo()));
		info.append(formatString("studentName", student.getStudentName()));
		info.append(formatString("sex", student.getSex()));
		info.append(formatString("studentAcademy", student.getStudentAcademy()));
		info.append(formatString("studentMajor", student.getStudentMajor()));
		info.append(formatString("studentClass", student.getStudentClass().toString()));
		info.append(formatString("password", student.getPassword()));
		info.deleteCharAt(info.length()-1);
		info.append("}");
		return new String(info);
	}
	private static String formatString(String key,String value){
		return "\""+key+"\":"+"\""+value+"\",";
	}
	public static boolean updateStudentPerson(String studentNo, String studentName, String sex, String studentAcademy,
			String studentMajor, String studentClass, String password) {
		try {
			StudentDAO studentDAO=new StudentDAO();
			Transaction transaction=studentDAO.getSession().beginTransaction();
			Student student=new Student(studentNo, studentName, sex, studentAcademy, studentMajor, Integer.valueOf(studentClass), password);
			System.out.println("开始更新");
			System.out.println(student);
			studentDAO.getSession().update(student);
			transaction.commit();
			System.out.println("更新成功");
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}
}
