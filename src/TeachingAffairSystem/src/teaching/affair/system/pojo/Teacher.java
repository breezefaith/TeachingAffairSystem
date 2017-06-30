package teaching.affair.system.pojo;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public class Teacher implements java.io.Serializable {

	// Fields

	private String teacherNo;
	private String teacherName;
	private String sex;
	private String teacherAcademy;
	private String teacherTitle;
	private String teacherEmail;
	private String password;

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** minimal constructor */
	public Teacher(String teacherNo) {
		this.teacherNo = teacherNo;
	}

	/** full constructor */
	public Teacher(String teacherNo, String teacherName, String sex, String teacherAcademy, String teacherTitle,
			String teacherEmail, String password) {
		this.teacherNo = teacherNo;
		this.teacherName = teacherName;
		this.sex = sex;
		this.teacherAcademy = teacherAcademy;
		this.teacherTitle = teacherTitle;
		this.teacherEmail = teacherEmail;
		this.password = password;
	}

	// Property accessors

	public String getTeacherNo() {
		return this.teacherNo;
	}

	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
	}

	public String getTeacherName() {
		return this.teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTeacherAcademy() {
		return this.teacherAcademy;
	}

	public void setTeacherAcademy(String teacherAcademy) {
		this.teacherAcademy = teacherAcademy;
	}

	public String getTeacherTitle() {
		return this.teacherTitle;
	}

	public void setTeacherTitle(String teacherTitle) {
		this.teacherTitle = teacherTitle;
	}

	public String getTeacherEmail() {
		return this.teacherEmail;
	}

	public void setTeacherEmail(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((teacherAcademy == null) ? 0 : teacherAcademy.hashCode());
		result = prime * result + ((teacherEmail == null) ? 0 : teacherEmail.hashCode());
		result = prime * result + ((teacherName == null) ? 0 : teacherName.hashCode());
		result = prime * result + ((teacherNo == null) ? 0 : teacherNo.hashCode());
		result = prime * result + ((teacherTitle == null) ? 0 : teacherTitle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (teacherAcademy == null) {
			if (other.teacherAcademy != null)
				return false;
		} else if (!teacherAcademy.equals(other.teacherAcademy))
			return false;
		if (teacherEmail == null) {
			if (other.teacherEmail != null)
				return false;
		} else if (!teacherEmail.equals(other.teacherEmail))
			return false;
		if (teacherName == null) {
			if (other.teacherName != null)
				return false;
		} else if (!teacherName.equals(other.teacherName))
			return false;
		if (teacherNo == null) {
			if (other.teacherNo != null)
				return false;
		} else if (!teacherNo.equals(other.teacherNo))
			return false;
		if (teacherTitle == null) {
			if (other.teacherTitle != null)
				return false;
		} else if (!teacherTitle.equals(other.teacherTitle))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Teacher [teacherNo=" + teacherNo + ", teacherName=" + teacherName + ", sex=" + sex + ", teacherAcademy="
				+ teacherAcademy + ", teacherTitle=" + teacherTitle + ", teacherEmail=" + teacherEmail + ", password="
				+ password + "]";
	}

}