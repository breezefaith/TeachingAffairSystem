package teaching.affair.system.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import teaching.affair.system.dao.SystemUserViewDAO;
import teaching.affair.system.pojo.view.SystemUserView;
import teaching.affair.system.pojo.view.SystemUserViewId;
import teaching.affair.system.util.MD5Util;

public class LoginAction extends ActionSupport implements ServletResponseAware{
	private String username;
	private String password;
	private String identity;
	private HttpServletResponse response;
	
	private String errorMessage="用户名、密码或身份错误";
	@Override
	public String execute(){
		long time1=System.currentTimeMillis();
		if(password!=null){
			password=MD5Util.string2MD5(password);
		}
		SystemUserViewDAO systemUserViewDAO=new SystemUserViewDAO();
		SystemUserViewId systemUserViewId=new SystemUserViewId(username, password, identity);
		SystemUserView systemUserView=systemUserViewDAO.findById(systemUserViewId);
		long time2=System.currentTimeMillis();
		if(systemUserView!=null){
			System.out.println(systemUserView);
			System.out.println(time2-time1);
			ActionContext actionContext=ActionContext.getContext();
			actionContext.put("username", username);
			actionContext.put("identity", identity);
			Cookie cookieUsername=new Cookie("username", username);
			cookieUsername.setPath("/");
			Cookie cookieIdentity=new Cookie("identity",identity);
			cookieIdentity.setPath("/");
			response.addCookie(cookieUsername);
			response.addCookie(cookieIdentity);
			if(identity.equals("manager")){
				System.out.println("return manager");
				return identity;
			}else if(identity.equals("teacher")){
				System.out.println("return teacher");
				return identity;
			}else if(identity.equals("student")){
				System.out.println("return student");
				return identity;
			}else{
				System.out.println("return SUCCESS");
				return SUCCESS;
			}
			
			
		}else{
			System.out.println("systemUserView=null");
			System.out.println(time2-time1);
			errorMessage="用户名、密码或身份错误";
			return INPUT;
		}
//		return SUCCESS;
	}

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getIdentity() {
		return identity;
	}


	public void setIdentity(String identity) {
		this.identity = identity;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		response=arg0;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
