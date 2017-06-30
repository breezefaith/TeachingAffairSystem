package teaching.affair.system.action;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import teaching.affair.system.model.ManagerCourse;
import teaching.affair.system.model.ManagerCourseOption;
import teaching.affair.system.model.ManagerManager;
import teaching.affair.system.model.ManagerSemester;
import teaching.affair.system.model.ManagerSemesterCourse;
import teaching.affair.system.model.ManagerStudent;
import teaching.affair.system.model.ManagerTeacher;
import teaching.affair.system.model.ManagerTeacherOption;
import teaching.affair.system.pojo.Course;
import teaching.affair.system.pojo.Student;
import teaching.affair.system.pojo.Teacher;
import teaching.affair.system.util.MD5Util;


public class ManagerAction extends ActionSupport{
	
	
	/*½ÌÊ¦²Ù×÷*/
	public String updateTeacher(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
//		System.out.println(request.getParameterMap().size());
		if(request.getMethod().equals("GET")){
			return ERROR;
		}
		String teacherNo=request.getParameter("teacherNo");
		String teacherName=request.getParameter("teacherName");
		String sex=request.getParameter("sex");
		String teacherAcademy=request.getParameter("teacherAcademy");
		String teacherTitle=request.getParameter("teacherTitle");
		String teacherEmail=request.getParameter("teacherEmail");
		String password=request.getParameter("password");
		if(password.length()!=32){
			if(password.equals("")){
				password="888888";
			}
			password=MD5Util.string2MD5(password);
		}
		System.out.println(new Teacher(teacherNo, teacherName, sex, teacherAcademy, teacherTitle, teacherEmail, password));
		
		if(ManagerTeacher.updateTeacher(teacherNo, teacherName, sex, teacherAcademy, teacherTitle, teacherEmail, password)){
			return null;
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				response.setCharacterEncoding("UTF-8");
				out.println("¸üÐÂÊ§°Ü");
				out.flush();
				out.close();
				return null;
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return ERROR;
			}
		}
	}
	public String insertTeacher(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		if(request.getMethod().equals("GET")){
			return ERROR;
		}
		String teacherNo=request.getParameter("teacherNo");
		String teacherName=request.getParameter("teacherName");
		String sex=request.getParameter("sex");
		String teacherAcademy=request.getParameter("teacherAcademy");
		String teacherTitle=request.getParameter("teacherTitle");
		String teacherEmail=request.getParameter("teacherEmail");
		String password=request.getParameter("password");
		if(password.length()!=32){
			if(password.equals("")){
				password="888888";
			}
			password=MD5Util.string2MD5(password);
		}
		System.out.println(new Teacher(teacherNo, teacherName, sex, teacherAcademy, teacherTitle, teacherEmail, password));
		
		if(ManagerTeacher.insertTeacher(teacherNo, teacherName, sex, teacherAcademy, teacherTitle, teacherEmail, password)){
			return null;
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				response.setCharacterEncoding("UTF-8");
				out.println("²åÈëÊ§°Ü");
				out.flush();
				out.close();
				return null;
			} catch (IOException e) {
				e.printStackTrace();
				return ERROR;
			}
		}
	}
	public String deleteTeacher(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		if(request.getMethod().equals("GET")){
			return ERROR;
		}
		String teacherNo=request.getParameter("teacherNo");
		if(ManagerTeacher.deleteTeacher(teacherNo)){
			return null;
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				response.setCharacterEncoding("UTF-8");
				out.println("É¾³ýÊ§°Ü");
				out.flush();
				out.close();
				return null;
			} catch (IOException e) {
				e.printStackTrace();
				return ERROR;
			}
		}
	}
	public String getTeacher(){
		try {
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpServletResponse response=ServletActionContext.getResponse();
//			ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			response.setCharacterEncoding("UTF-8");
			out.println(ManagerTeacher.getJsonString());
			out.flush();
			out.close();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	/*Ñ§Éú²Ù×÷*/
	public String getStudent(){
		try {
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpServletResponse response=ServletActionContext.getResponse();
//			ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			response.setCharacterEncoding("UTF-8");
			out.println(ManagerStudent.getJsonString());
			out.flush();
			out.close();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	public String updateStudent(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
//		System.out.println(request.getParameterMap().size());
		if(request.getMethod().equals("GET")){
			return ERROR;
		}
		String studentNo=request.getParameter("studentNo");
		String studentName=request.getParameter("studentName");
		String sex=request.getParameter("sex");
		String studentAcademy=request.getParameter("studentAcademy");
		String studentMajor=request.getParameter("studentMajor");
		String studentClass=request.getParameter("studentClass");
		String password=request.getParameter("password");
		if(password.length()!=32){
			if(password.equals("")){
				password="888888";
			}
			password=MD5Util.string2MD5(password);
		}
		if(ManagerStudent.updateStudent(studentNo, studentName, sex, studentAcademy, studentMajor, studentClass, password)){
			return null;
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				response.setCharacterEncoding("UTF-8");
				out.println("¸üÐÂÊ§°Ü");
				out.flush();
				out.close();
				return null;
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return ERROR;
			}
		}
	}
	public String insertStudent(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		if(request.getMethod().equals("GET")){
			return ERROR;
		}
		String studentNo=request.getParameter("studentNo");
		String studentName=request.getParameter("studentName");
		String sex=request.getParameter("sex");
		String studentAcademy=request.getParameter("studentAcademy");
		String studentMajor=request.getParameter("studentMajor");
		String studentClass=request.getParameter("studentClass");
		String password=request.getParameter("password");
		if(password.length()!=32){
			if(password.equals("")){
				password="888888";
			}
			password=MD5Util.string2MD5(password);
		}
		System.out.println(new Student(studentNo, studentName, sex, studentAcademy, studentMajor, Integer.valueOf(studentClass), password));
		if(ManagerStudent.insertStudent(studentNo, studentName, sex, studentAcademy, studentMajor, studentClass, password)){
			return null;
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				response.setCharacterEncoding("UTF-8");
				out.println("²åÈëÊ§°Ü");
				out.flush();
				out.close();
				return null;
			} catch (IOException e) {
				e.printStackTrace();
				return ERROR;
			}
		}
	}
	public String deleteStudent(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		if(request.getMethod().equals("GET")){
			return ERROR;
		}
		String studentNo=request.getParameter("studentNo");
		if(ManagerStudent.deleteStudent(studentNo)){
			return null;
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				response.setCharacterEncoding("UTF-8");
				out.println("É¾³ýÊ§°Ü");
				out.flush();
				out.close();
				return null;
			} catch (IOException e) {
				e.printStackTrace();
				return ERROR;
			}
		}
	}
	/*¿Î³Ì²Ù×÷*/
	public String getCourse(){
		try {
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpServletResponse response=ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			response.setCharacterEncoding("UTF-8");
			out.println(ManagerCourse.getJsonString());
			out.flush();
			out.close();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	public String updateCourse(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		if(request.getMethod().equals("GET")){
			return ERROR;
		}
		String courseNo=request.getParameter("courseNo");
		String courseName=request.getParameter("courseName");
		String courseAcademy=request.getParameter("courseAcademy");
		String courseCategory=request.getParameter("courseCategory");
		if(ManagerCourse.updateCourse(courseNo, courseName, courseAcademy, courseCategory)){
			return null;
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				response.setCharacterEncoding("UTF-8");
				out.println("¸üÐÂÊ§°Ü");
				out.flush();
				out.close();
				return null;
				
			} catch (IOException e) {
				e.printStackTrace();
				return ERROR;
			}
		}
	}
	public String insertCourse(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		if(request.getMethod().equals("GET")){
			return ERROR;
		}
		String courseNo=request.getParameter("courseNo");
		String courseName=request.getParameter("courseName");
		String courseAcademy=request.getParameter("courseAcademy");
		String courseCategory=request.getParameter("courseCategory");
		System.out.println(new Course(courseNo, courseName, courseAcademy,courseCategory));
		if(ManagerCourse.insertCourse(courseNo, courseName, courseAcademy,courseCategory)){
			return null;
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				response.setCharacterEncoding("UTF-8");
				out.println("²åÈëÊ§°Ü");
				out.flush();
				out.close();
				return null;
			} catch (IOException e) {
				e.printStackTrace();
				return ERROR;
			}
		}
	}
	public String deleteCourse(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		if(request.getMethod().equals("GET")){
			return ERROR;
		}
		String courseNo=request.getParameter("courseNo");
		if(ManagerCourse.deleteCourse(courseNo)){
			return null;
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				response.setCharacterEncoding("UTF-8");
				out.println("É¾³ýÊ§°Ü");
				out.flush();
				out.close();
				return null;
			} catch (IOException e) {
				e.printStackTrace();
				return ERROR;
			}
		}
	}
	
	/*Ñ§ÆÚ²Ù×÷*/
	public String getSemester(){
		try {
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpServletResponse response=ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			response.setCharacterEncoding("UTF-8");
			out.println(ManagerSemester.getJsonString());
			out.flush();
			out.close();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	public String updateSemester(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		if(request.getMethod().equals("GET")){
			return ERROR;
		}
		String semesterNo=request.getParameter("semesterNo");
		String semesterName=request.getParameter("semesterName");
		String startTime=request.getParameter("startTime");
		String endTime=request.getParameter("endTime");
		if(ManagerSemester.updateSemester(semesterNo,semesterName,startTime,endTime)){
			return null;
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				response.setCharacterEncoding("UTF-8");
				out.println("¸üÐÂÊ§°Ü");
				out.flush();
				out.close();
				return null;
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return ERROR;
			}
		}
	}
	public String insertSemester(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		if(request.getMethod().equals("GET")){
			return ERROR;
		}
		String semesterNo=request.getParameter("semesterNo");
		String semesterName=request.getParameter("semesterName");
		String startTime=request.getParameter("startTime");
		String endTime=request.getParameter("endTime");
		if(ManagerSemester.insertSemester(semesterNo,semesterName,startTime,endTime)){
			return null;
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				response.setCharacterEncoding("UTF-8");
				out.println("²åÈëÊ§°Ü");
				out.flush();
				out.close();
				return null;
			} catch (IOException e) {
				e.printStackTrace();
				return ERROR;
			}
		}
	}
	public String deleteSemester(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		if(request.getMethod().equals("GET")){
			return ERROR;
		}
		String semesterNo=request.getParameter("semesterNo");
		if(ManagerSemester.deleteSemester(semesterNo)){
			return null;
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				response.setCharacterEncoding("UTF-8");
				out.println("É¾³ýÊ§°Ü");
				out.flush();
				out.close();
				return null;
			} catch (IOException e) {
				e.printStackTrace();
				return ERROR;
			}
		}
	}
	
	public String getCourseOption(){
		try {
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpServletResponse response=ServletActionContext.getResponse();
			String semesterNo=request.getParameter("semesterNo");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			response.setCharacterEncoding("UTF-8");
			out.println(ManagerCourseOption.getJsonString(semesterNo));
			out.flush();
			out.close();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	public String getTeacherOption(){
		try {
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpServletResponse response=ServletActionContext.getResponse();
			String semesterNo=request.getParameter("semesterNo");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			response.setCharacterEncoding("UTF-8");
			out.println(ManagerTeacherOption.getJsonString(semesterNo));
			out.flush();
			out.close();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	public String insertSemesterCourse(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		if(request.getMethod().equals("GET")){
			return ERROR;
		}
		String semesterNo=request.getParameter("semesterNo");
		String courseNo=request.getParameter("courseNo");
		String teacherNo=request.getParameter("teacherNo");
		String startWeek=request.getParameter("startWeek");
		String endWeek=request.getParameter("endWeek");
		String expectNum=request.getParameter("expectNum");
		
		if(ManagerSemesterCourse.insertSemesterCourse(semesterNo,courseNo,teacherNo,startWeek,endWeek,expectNum)){
			return null;
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				response.setCharacterEncoding("UTF-8");
				out.println("²åÈëÊ§°Ü");
				out.flush();
				out.close();
				return null;
			} catch (IOException e) {
				e.printStackTrace();
				return ERROR;
			}
		}
	}
	public String updateSemesterCourse(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		if(request.getMethod().equals("GET")){
			return ERROR;
		}
		String semesterNo=request.getParameter("semesterNo");
		String courseNo=request.getParameter("courseNo");
		String teacherNo=request.getParameter("teacherNo");
		String startWeek=request.getParameter("startWeek");
		String endWeek=request.getParameter("endWeek");
		String expectNum=request.getParameter("expectNum");
		
		if(ManagerSemesterCourse.updateSemesterCourse(semesterNo,courseNo,teacherNo,startWeek,endWeek,expectNum)){
			return null;
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				response.setCharacterEncoding("UTF-8");
				out.println("²åÈëÊ§°Ü");
				out.flush();
				out.close();
				return null;
			} catch (IOException e) {
				e.printStackTrace();
				return ERROR;
			}
		}
	}
	public String deleteSemesterCourse(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		if(request.getMethod().equals("GET")){
			return ERROR;
		}
		String semesterNo=request.getParameter("semesterNo");
		String courseNo=request.getParameter("courseNo");
		String teacherNo=request.getParameter("teacherNo");
		String startWeek=request.getParameter("startWeek");
		String endWeek=request.getParameter("endWeek");
		String expectNum=request.getParameter("expectNum");
		
		if(ManagerSemesterCourse.deleteSemesterCourse(semesterNo,courseNo,teacherNo,startWeek,endWeek,expectNum)){
			return null;
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				response.setCharacterEncoding("UTF-8");
				out.println("²åÈëÊ§°Ü");
				out.flush();
				out.close();
				return null;
			} catch (IOException e) {
				e.printStackTrace();
				return ERROR;
			}
		}
	}
	public String setCurrentSemester(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		if(request.getMethod().equals("GET")){
			return ERROR;
		}
		String semesterNo=request.getParameter("semesterNo");
		
		if(ManagerSemester.setCurrentSemester(semesterNo)){
			return null;
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				response.setCharacterEncoding("UTF-8");
				out.println("¸üÐÂÊ§°Ü");
				out.flush();
				out.close();
				return null;
			} catch (IOException e) {
				e.printStackTrace();
				return ERROR;
			}
		}
	}
	
	/*¹ÜÀíÔ±²Ù×÷*/
	public String getManager(){
		try {
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpServletResponse response=ServletActionContext.getResponse();
//			ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			response.setCharacterEncoding("UTF-8");
			out.println(ManagerManager.getJsonString());
			out.flush();
			out.close();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	public String updateManager(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		if(request.getMethod().equals("GET")){
			return ERROR;
		}
		String managerNo=request.getParameter("managerNo");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(password.length()!=32){
			if(password.equals("")){
				password="888888";
			}
			password=MD5Util.string2MD5(password);
		}
		if(ManagerManager.updateManager(managerNo,username,password)){
			return null;
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				response.setCharacterEncoding("UTF-8");
				out.println("¸üÐÂÊ§°Ü");
				out.flush();
				out.close();
				return null;
				
			} catch (IOException e) {
				e.printStackTrace();
				return ERROR;
			}
		}
	}
	public String insertManager(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		if(request.getMethod().equals("GET")){
			return ERROR;
		}
		String managerNo=request.getParameter("managerNo");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(password.length()!=32){
			if(password.equals("")){
				password="888888";
			}
			password=MD5Util.string2MD5(password);
		}
		if(ManagerManager.insertManager(managerNo,username,password)){
			return null;
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				response.setCharacterEncoding("UTF-8");
				out.println("²åÈëÊ§°Ü");
				out.flush();
				out.close();
				return null;
			} catch (IOException e) {
				e.printStackTrace();
				return ERROR;
			}
		}
	}
	public String deleteManager(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		if(request.getMethod().equals("GET")){
			return ERROR;
		}
		String managerNo=request.getParameter("managerNo");
		if(ManagerManager.deleteManager(managerNo)){
			return null;
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				response.setCharacterEncoding("UTF-8");
				out.println("É¾³ýÊ§°Ü");
				out.flush();
				out.close();
				return null;
			} catch (IOException e) {
				e.printStackTrace();
				return ERROR;
			}
		}
	}
	
}
