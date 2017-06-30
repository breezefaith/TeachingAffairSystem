package teaching.affair.system.pojo.view;

/**
 * CurrentSemesterSchduleViewId entity. @author MyEclipse Persistence Tools
 */

public class CurrentSemesterSchduleViewId implements java.io.Serializable {

	// Fields

	private Integer semesterNo;
	private String semesterName;
	private String courseNo;
	private String courseName;
	private String teacherNo;
	private String teacherName;
	private Integer startWeek;
	private Integer endWeek;
	private String day;
	private Integer startClassNo;
	private Integer endClassNo;

	// Constructors

	/** default constructor */
	public CurrentSemesterSchduleViewId() {
	}

	/** minimal constructor */
	public CurrentSemesterSchduleViewId(Integer semesterNo, String semesterName, String courseName, Integer startWeek,
			Integer endWeek, String day, Integer startClassNo, Integer endClassNo) {
		this.semesterNo = semesterNo;
		this.semesterName = semesterName;
		this.courseName = courseName;
		this.startWeek = startWeek;
		this.endWeek = endWeek;
		this.day = day;
		this.startClassNo = startClassNo;
		this.endClassNo = endClassNo;
	}

	/** full constructor */
	public CurrentSemesterSchduleViewId(Integer semesterNo, String semesterName, String courseNo, String courseName,
			String teacherNo, String teacherName, Integer startWeek, Integer endWeek, String day, Integer startClassNo,
			Integer endClassNo) {
		this.semesterNo = semesterNo;
		this.semesterName = semesterName;
		this.courseNo = courseNo;
		this.courseName = courseName;
		this.teacherNo = teacherNo;
		this.teacherName = teacherName;
		this.startWeek = startWeek;
		this.endWeek = endWeek;
		this.day = day;
		this.startClassNo = startClassNo;
		this.endClassNo = endClassNo;
	}

	// Property accessors

	public Integer getSemesterNo() {
		return this.semesterNo;
	}

	public void setSemesterNo(Integer semesterNo) {
		this.semesterNo = semesterNo;
	}

	public String getSemesterName() {
		return this.semesterName;
	}

	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}

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

	public Integer getStartWeek() {
		return this.startWeek;
	}

	public void setStartWeek(Integer startWeek) {
		this.startWeek = startWeek;
	}

	public Integer getEndWeek() {
		return this.endWeek;
	}

	public void setEndWeek(Integer endWeek) {
		this.endWeek = endWeek;
	}

	public String getDay() {
		return this.day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Integer getStartClassNo() {
		return this.startClassNo;
	}

	public void setStartClassNo(Integer startClassNo) {
		this.startClassNo = startClassNo;
	}

	public Integer getEndClassNo() {
		return this.endClassNo;
	}

	public void setEndClassNo(Integer endClassNo) {
		this.endClassNo = endClassNo;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CurrentSemesterSchduleViewId))
			return false;
		CurrentSemesterSchduleViewId castOther = (CurrentSemesterSchduleViewId) other;

		return ((this.getSemesterNo() == castOther.getSemesterNo()) || (this.getSemesterNo() != null
				&& castOther.getSemesterNo() != null && this.getSemesterNo().equals(castOther.getSemesterNo())))
				&& ((this.getSemesterName() == castOther.getSemesterName())
						|| (this.getSemesterName() != null && castOther.getSemesterName() != null
								&& this.getSemesterName().equals(castOther.getSemesterName())))
				&& ((this.getCourseNo() == castOther.getCourseNo()) || (this.getCourseNo() != null
						&& castOther.getCourseNo() != null && this.getCourseNo().equals(castOther.getCourseNo())))
				&& ((this.getCourseName() == castOther.getCourseName()) || (this.getCourseName() != null
						&& castOther.getCourseName() != null && this.getCourseName().equals(castOther.getCourseName())))
				&& ((this.getTeacherNo() == castOther.getTeacherNo()) || (this.getTeacherNo() != null
						&& castOther.getTeacherNo() != null && this.getTeacherNo().equals(castOther.getTeacherNo())))
				&& ((this.getTeacherName() == castOther.getTeacherName())
						|| (this.getTeacherName() != null && castOther.getTeacherName() != null
								&& this.getTeacherName().equals(castOther.getTeacherName())))
				&& ((this.getStartWeek() == castOther.getStartWeek()) || (this.getStartWeek() != null
						&& castOther.getStartWeek() != null && this.getStartWeek().equals(castOther.getStartWeek())))
				&& ((this.getEndWeek() == castOther.getEndWeek()) || (this.getEndWeek() != null
						&& castOther.getEndWeek() != null && this.getEndWeek().equals(castOther.getEndWeek())))
				&& ((this.getDay() == castOther.getDay()) || (this.getDay() != null && castOther.getDay() != null
						&& this.getDay().equals(castOther.getDay())))
				&& ((this.getStartClassNo() == castOther.getStartClassNo())
						|| (this.getStartClassNo() != null && castOther.getStartClassNo() != null
								&& this.getStartClassNo().equals(castOther.getStartClassNo())))
				&& ((this.getEndClassNo() == castOther.getEndClassNo())
						|| (this.getEndClassNo() != null && castOther.getEndClassNo() != null
								&& this.getEndClassNo().equals(castOther.getEndClassNo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getSemesterNo() == null ? 0 : this.getSemesterNo().hashCode());
		result = 37 * result + (getSemesterName() == null ? 0 : this.getSemesterName().hashCode());
		result = 37 * result + (getCourseNo() == null ? 0 : this.getCourseNo().hashCode());
		result = 37 * result + (getCourseName() == null ? 0 : this.getCourseName().hashCode());
		result = 37 * result + (getTeacherNo() == null ? 0 : this.getTeacherNo().hashCode());
		result = 37 * result + (getTeacherName() == null ? 0 : this.getTeacherName().hashCode());
		result = 37 * result + (getStartWeek() == null ? 0 : this.getStartWeek().hashCode());
		result = 37 * result + (getEndWeek() == null ? 0 : this.getEndWeek().hashCode());
		result = 37 * result + (getDay() == null ? 0 : this.getDay().hashCode());
		result = 37 * result + (getStartClassNo() == null ? 0 : this.getStartClassNo().hashCode());
		result = 37 * result + (getEndClassNo() == null ? 0 : this.getEndClassNo().hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "CurrentSemesterSchduleViewId [semesterNo=" + semesterNo + ", semesterName=" + semesterName
				+ ", courseNo=" + courseNo + ", courseName=" + courseName + ", teacherNo=" + teacherNo
				+ ", teacherName=" + teacherName + ", startWeek=" + startWeek + ", endWeek=" + endWeek + ", day=" + day
				+ ", startClassNo=" + startClassNo + ", endClassNo=" + endClassNo + "]";
	}

}