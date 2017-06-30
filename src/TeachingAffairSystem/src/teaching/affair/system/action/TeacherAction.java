package teaching.affair.system.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import teaching.affair.system.model.StudentPerson;
import teaching.affair.system.model.TeacherCourse;
import teaching.affair.system.model.TeacherPerson;
import teaching.affair.system.model.TeacherScore;
import teaching.affair.system.util.MD5Util;

public class TeacherAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7553414783608776329L;

	public String getTeacherPerson(){
		try {
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpServletResponse response=ServletActionContext.getResponse();
			String teacherNo=request.getParameter("teacherNo");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			response.setCharacterEncoding("UTF-8");
			out.println(TeacherPerson.getJsonString(teacherNo));
			out.flush();
			out.close();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	public String updateTeacherPerson(){
		try{
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpServletResponse response=ServletActionContext.getResponse();
			String teacherNo=request.getParameter("teacherNo");
			String teacherName=request.getParameter("teacherName");
			String sex=request.getParameter("sex");
			String teacherAcademy=request.getParameter("teacherAcademy");
			String teacherTitle=request.getParameter("teacherTitle");
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			if(password.length()!=32){
				if(password.equals("")){
					password="888888";
				}
				password=MD5Util.string2MD5(password);
			}
			if(TeacherPerson.updateStudentPerson(teacherNo, teacherName, sex, teacherAcademy, teacherTitle, email, password)==true){

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
	public String getTeacherCourse(){
		try {
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpServletResponse response=ServletActionContext.getResponse();
			String teacherNo=request.getParameter("teacherNo");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			response.setCharacterEncoding("UTF-8");
			out.println(TeacherCourse.getJsonString(teacherNo));
			out.flush();
			out.close();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	public String updateScore(){
		try{
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpServletResponse response=ServletActionContext.getResponse();
			String semesterNo=request.getParameter("semesterNo");
			String courseNo=request.getParameter("courseNo");
			String studentNo=request.getParameter("studentNo");
			String score=request.getParameter("score");
			
			if(TeacherScore.updateScore(semesterNo, courseNo, studentNo, score)){

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
}
