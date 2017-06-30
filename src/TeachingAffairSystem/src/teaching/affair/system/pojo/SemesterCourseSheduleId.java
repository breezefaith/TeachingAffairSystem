package teaching.affair.system.pojo;

/**
 * SemesterCourseSheduleId entity. @author MyEclipse Persistence Tools
 */

public class SemesterCourseSheduleId implements java.io.Serializable {

	// Fields

	private Integer semesterCourseNo;
	private String day;

	// Constructors

	/** default constructor */
	public SemesterCourseSheduleId() {
	}

	/** full constructor */
	public SemesterCourseSheduleId(Integer semesterCourseNo, String day) {
		this.semesterCourseNo = semesterCourseNo;
		this.day = day;
	}

	// Property accessors

	public Integer getSemesterCourseNo() {
		return this.semesterCourseNo;
	}

	public void setSemesterCourseNo(Integer semesterCourseNo) {
		this.semesterCourseNo = semesterCourseNo;
	}

	public String getDay() {
		return this.day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SemesterCourseSheduleId))
			return false;
		SemesterCourseSheduleId castOther = (SemesterCourseSheduleId) other;

		return ((this.getSemesterCourseNo() == castOther.getSemesterCourseNo())
				|| (this.getSemesterCourseNo() != null && castOther.getSemesterCourseNo() != null
						&& this.getSemesterCourseNo().equals(castOther.getSemesterCourseNo())))
				&& ((this.getDay() == castOther.getDay()) || (this.getDay() != null && castOther.getDay() != null
						&& this.getDay().equals(castOther.getDay())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getSemesterCourseNo() == null ? 0 : this.getSemesterCourseNo().hashCode());
		result = 37 * result + (getDay() == null ? 0 : this.getDay().hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "SemesterCourseSheduleId [semesterCourseNo=" + semesterCourseNo + ", day=" + day + "]";
	}

}