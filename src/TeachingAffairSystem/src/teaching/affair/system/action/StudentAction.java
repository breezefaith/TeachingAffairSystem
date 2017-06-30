package teaching.affair.system.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import teaching.affair.system.model.ManagerStudent;
import teaching.affair.system.model.StudentCourse;
import teaching.affair.system.model.StudentPerson;
import teaching.affair.system.util.MD5Util;

public class StudentAction extends ActionSupport{
	public String getStudentPerson(){
		try {
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpServletResponse response=ServletActionContext.getResponse();
			String studentNo=request.getParameter("studentNo");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			response.setCharacterEncoding("UTF-8");
			out.println(StudentPerson.getJsonString(studentNo));
			out.flush();
			out.close();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	public String updateStudentPerson(){
		try {
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpServletResponse response=ServletActionContext.getResponse();
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
			if(StudentPerson.updateStudentPerson(studentNo,studentName,sex,studentAcademy,studentMajor,studentClass,password)==true){
				
			}else{
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				response.setCharacterEncoding("UTF-8");
				out.println("ÐÞ¸ÄÊ§°Ü");
				out.flush();
				out.close();
			}
			
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	public String selectCourse(){
		try {
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpServletResponse response=ServletActionContext.getResponse();
			String semesterNo=request.getParameter("semesterNo");
			String studentNo=request.getParameter("studentNo");
			String courseNo=request.getParameter("courseNo");
			
			if(StudentCourse.insertSelectCourse(semesterNo,studentNo,courseNo)){
				return null;
			}else{
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				response.setCharacterEncoding("UTF-8");
				out.println("ÐÞ¸ÄÊ§°Ü");
				out.flush();
				out.close();
			}
			
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	public String removeCourse(){
		try {
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpServletResponse response=ServletActionContext.getResponse();
			String semesterNo=request.getParameter("semesterNo");
			String studentNo=request.getParameter("studentNo");
			String courseNo=request.getParameter("courseNo");
			
			if(StudentCourse.removeSelectCourse(semesterNo,studentNo,courseNo)){
				return null;
			}else{
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				response.setCharacterEncoding("UTF-8");
				out.println("ÐÞ¸ÄÊ§°Ü");
				out.flush();
				out.close();
			}
			
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	public String getSelectedCourse(){
		try {
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpServletResponse response=ServletActionContext.getResponse();
			String studentNo=request.getParameter("studentNo");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			response.setCharacterEncoding("UTF-8");
			out.println(StudentCourse.getSelectedCourseJsonString(studentNo));
			out.flush();
			out.close();
			
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	public String getStudentCourse(){
		try {
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpServletResponse response=ServletActionContext.getResponse();
			String studentNo=request.getParameter("studentNo");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			response.setCharacterEncoding("UTF-8");
			out.println(StudentCourse.getStudentCourseJsonString(studentNo));
			out.flush();
			out.close();
			
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
}
