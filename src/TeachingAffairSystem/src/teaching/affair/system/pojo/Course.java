package teaching.affair.system.pojo;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */

public class Course implements java.io.Serializable {

	// Fields

	private String courseNo;
	private String courseName;
	private String courseAcademy;
	private String courseCategory;

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** minimal constructor */
	public Course(String courseNo, String courseName) {
		this.courseNo = courseNo;
		this.courseName = courseName;
	}

	/** full constructor */
	public Course(String courseNo, String courseName, String courseAcademy, String courseCategory) {
		this.courseNo = courseNo;
		this.courseName = courseName;
		this.courseAcademy = courseAcademy;
		this.courseCategory = courseCategory;
	}

	// Property accessors

	public String getCourseNo() {
		return this.courseNo;
	}

	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseAcademy() {
		return this.courseAcademy;
	}

	public void setCourseAcademy(String courseAcademy) {
		this.courseAcademy = courseAcademy;
	}

	public String getCourseCategory() {
		return this.courseCategory;
	}

	public void setCourseCategory(String courseCategory) {
		this.courseCategory = courseCategory;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseAcademy == null) ? 0 : courseAcademy.hashCode());
		result = prime * result + ((courseCategory == null) ? 0 : courseCategory.hashCode());
		result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
		result = prime * result + ((courseNo == null) ? 0 : courseNo.hashCode());
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
		Course other = (Course) obj;
		if (courseAcademy == null) {
			if (other.courseAcademy != null)
				return false;
		} else if (!courseAcademy.equals(other.courseAcademy))
			return false;
		if (courseCategory == null) {
			if (other.courseCategory != null)
				return false;
		} else if (!courseCategory.equals(other.courseCategory))
			return false;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		if (courseNo == null) {
			if (other.courseNo != null)
				return false;
		} else if (!courseNo.equals(other.courseNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Course [courseNo=" + courseNo + ", courseName=" + courseName + ", courseAcademy=" + courseAcademy
				+ ", courseCategory=" + courseCategory + "]";
	}

}