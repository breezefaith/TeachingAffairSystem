package teaching.affair.system.action;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {
	private String testText;
	private String testText2;
	@Override
	public String execute(){
		System.out.println(testText==null);
		System.out.println(testText2==null);
		return SUCCESS;
	}
	public String getTestText() {
		return testText;
	}
	public void setTestText(String testText) {
		this.testText = testText;
	}
	public String getTestText2() {
		return testText2;
	}
	public void setTestText2(String testText2) {
		this.testText2 = testText2;
	}
}
