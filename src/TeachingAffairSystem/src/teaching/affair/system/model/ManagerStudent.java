package teaching.affair.system.model;

import java.util.List;

import org.hibernate.Transaction;

import teaching.affair.system.dao.StudentDAO;
import teaching.affair.system.dao.StudentDAO;
import teaching.affair.system.pojo.Student;
import teaching.affair.system.pojo.Student;

public class ManagerStudent {
	public static String getJsonString(){
		StudentDAO studentDAO=new StudentDAO();
		List<Student> students=studentDAO.findAll();
		StringBuffer studentInfo=new StringBuffer("[");
		for(Student item:students){
			studentInfo.append("{");
			studentInfo.append(formatString("studentNo", item.getStudentNo()));
			studentInfo.append(formatString("studentName", item.getStudentName()));
			studentInfo.append(formatString("studentAcademy", item.getStudentAcademy()));
			studentInfo.append(formatString("studentMajor", item.getStudentMajor()));
			studentInfo.append(formatString("sex", item.getSex()));
			studentInfo.append(formatString("studentClass", String.valueOf(item.getStudentClass())));
			studentInfo.append(formatString("password", item.getPassword()));
			studentInfo.deleteCharAt(studentInfo.length()-1);
			studentInfo.append("},");
		}
		studentInfo.deleteCharAt(studentInfo.length()-1);
		studentInfo.append("]");
		return new String(studentInfo);
	}
	public static boolean updateStudent(String studentNo,String studentName,String sex,String studentAcademy,String studentMajor,String studentClass,String password){
		try {
			StudentDAO studentDAO=new StudentDAO();
			Transaction transaction=studentDAO.getSession().beginTransaction();
//			Student Student=new Student(StudentNo, StudentName, sex, StudentAcademy, StudentTitle, StudentEmail, password);
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
	private static String formatString(String key,String value){
		return "\""+key+"\":"+"\""+value+"\",";
	}
	public static void main(String[] args) {
		System.out.println(getJsonString());
	}
	public static boolean insertStudent(String studentNo,String studentName,String sex,String studentAcademy,String studentMajor,String studentClass,String password) {
		try {
			StudentDAO studentDAO=new StudentDAO();
			Transaction transaction=studentDAO.getSession().beginTransaction();
			Student student=new Student(studentNo, studentName, sex, studentAcademy, studentMajor, Integer.valueOf(studentClass), password);
			System.out.println("开始插入");
			System.out.println(student);
			studentDAO.getSession().save(student);
			transaction.commit();
			System.out.println("插入成功");
			return true;
		} catch (RuntimeException e) {
			return false;
		}
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
}
