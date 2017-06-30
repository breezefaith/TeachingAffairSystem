package teaching.affair.system.pojo;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private String studentNo;
	private String studentName;
	private String sex;
	private String studentAcademy;
	private String studentMajor;
	private Integer studentClass;
	private String password;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(String studentNo) {
		this.studentNo = studentNo;
	}
	public Student(String studentNo, String studentName) {
		this.studentNo = studentNo;
		this.studentName = studentName;
	}

	/** full constructor */
	public Student(String studentNo, String studentName, String sex, String studentAcademy, String studentMajor,
			Integer studentClass, String password) {
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.sex = sex;
		this.studentAcademy = studentAcademy;
		this.studentMajor = studentMajor;
		this.studentClass = studentClass;
		this.password = password;
	}

	// Property accessors

	public String getStudentNo() {
		return this.studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getStudentAcademy() {
		return this.studentAcademy;
	}

	public void setStudentAcademy(String studentAcademy) {
		this.studentAcademy = studentAcademy;
	}

	public String getStudentMajor() {
		return this.studentMajor;
	}

	public void setStudentMajor(String studentMajor) {
		this.studentMajor = studentMajor;
	}

	public Integer getStudentClass() {
		return this.studentClass;
	}

	public void setStudentClass(Integer studentClass) {
		this.studentClass = studentClass;
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
		result = prime * result + ((studentAcademy == null) ? 0 : studentAcademy.hashCode());
		result = prime * result + ((studentClass == null) ? 0 : studentClass.hashCode());
		result = prime * result + ((studentMajor == null) ? 0 : studentMajor.hashCode());
		result = prime * result + ((studentName == null) ? 0 : studentName.hashCode());
		result = prime * result + ((studentNo == null) ? 0 : studentNo.hashCode());
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
		Student other = (Student) obj;
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
		if (studentAcademy == null) {
			if (other.studentAcademy != null)
				return false;
		} else if (!studentAcademy.equals(other.studentAcademy))
			return false;
		if (studentClass == null) {
			if (other.studentClass != null)
				return false;
		} else if (!studentClass.equals(other.studentClass))
			return false;
		if (studentMajor == null) {
			if (other.studentMajor != null)
				return false;
		} else if (!studentMajor.equals(other.studentMajor))
			return false;
		if (studentName == null) {
			if (other.studentName != null)
				return false;
		} else if (!studentName.equals(other.studentName))
			return false;
		if (studentNo == null) {
			if (other.studentNo != null)
				return false;
		} else if (!studentNo.equals(other.studentNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [studentNo=" + studentNo + ", studentName=" + studentName + ", sex=" + sex + ", studentAcademy="
				+ studentAcademy + ", studentMajor=" + studentMajor + ", studentClass=" + studentClass + ", password="
				+ password + "]";
	}

}