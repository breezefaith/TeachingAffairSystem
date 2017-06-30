package teaching.affair.system.pojo.view;

/**
 * SelectedCourseViewId entity. @author MyEclipse Persistence Tools
 */

public class SelectedCourseViewId implements java.io.Serializable {

	// Fields

	private String courseNo;
	private String courseName;
	private String courseAcademy;
	private String courseCategory;
	private String teacherNo;
	private String teacherName;
	private String teacherAcademy;
	private String teacherTitle;
	private String teacherEmail;
	private Integer semesterNo;
	private String semesterName;
	private Integer startWeek;
	private Integer endWeek;
	private Integer isCurrentSemester;

	// Constructors

	/** default constructor */
	public SelectedCourseViewId() {
	}

	/** minimal constructor */
	public SelectedCourseViewId(String courseNo, String courseName, String teacherNo, String semesterName,
			Integer startWeek, Integer endWeek) {
		this.courseNo = courseNo;
		this.courseName = courseName;
		this.teacherNo = teacherNo;
		this.semesterName = semesterName;
		this.startWeek = startWeek;
		this.endWeek = endWeek;
	}

	/** full constructor */
	public SelectedCourseViewId(String courseNo, String courseName, String courseAcademy, String courseCategory,
			String teacherNo, String teacherName, String teacherAcademy, String teacherTitle, String teacherEmail,
			Integer semesterNo, String semesterName, Integer startWeek, Integer endWeek, Integer isCurrentSemester) {
		this.courseNo = courseNo;
		this.courseName = courseName;
		this.courseAcademy = courseAcademy;
		this.courseCategory = courseCategory;
		this.teacherNo = teacherNo;
		this.teacherName = teacherName;
		this.teacherAcademy = teacherAcademy;
		this.teacherTitle = teacherTitle;
		this.teacherEmail = teacherEmail;
		this.semesterNo = semesterNo;
		this.semesterName = semesterName;
		this.startWeek = startWeek;
		this.endWeek = endWeek;
		this.isCurrentSemester = isCurrentSemester;
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

	public Integer getIsCurrentSemester() {
		return this.isCurrentSemester;
	}

	public void setIsCurrentSemester(Integer isCurrentSemester) {
		this.isCurrentSemester = isCurrentSemester;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SelectedCourseViewId))
			return false;
		SelectedCourseViewId castOther = (SelectedCourseViewId) other;

		return ((this.getCourseNo() == castOther.getCourseNo()) || (this.getCourseNo() != null
				&& castOther.getCourseNo() != null && this.getCourseNo().equals(castOther.getCourseNo())))
				&& ((this.getCourseName() == castOther.getCourseName()) || (this.getCourseName() != null
						&& castOther.getCourseName() != null && this.getCourseName().equals(castOther.getCourseName())))
				&& ((this.getCourseAcademy() == castOther.getCourseAcademy())
						|| (this.getCourseAcademy() != null && castOther.getCourseAcademy() != null
								&& this.getCourseAcademy().equals(castOther.getCourseAcademy())))
				&& ((this.getCourseCategory() == castOther.getCourseCategory())
						|| (this.getCourseCategory() != null && castOther.getCourseCategory() != null
								&& this.getCourseCategory().equals(castOther.getCourseCategory())))
				&& ((this.getTeacherNo() == castOther.getTeacherNo()) || (this.getTeacherNo() != null
						&& castOther.getTeacherNo() != null && this.getTeacherNo().equals(castOther.getTeacherNo())))
				&& ((this.getTeacherName() == castOther.getTeacherName())
						|| (this.getTeacherName() != null && castOther.getTeacherName() != null
								&& this.getTeacherName().equals(castOther.getTeacherName())))
				&& ((this.getTeacherAcademy() == castOther.getTeacherAcademy())
						|| (this.getTeacherAcademy() != null && castOther.getTeacherAcademy() != null
								&& this.getTeacherAcademy().equals(castOther.getTeacherAcademy())))
				&& ((this.getTeacherTitle() == castOther.getTeacherTitle())
						|| (this.getTeacherTitle() != null && castOther.getTeacherTitle() != null
								&& this.getTeacherTitle().equals(castOther.getTeacherTitle())))
				&& ((this.getTeacherEmail() == castOther.getTeacherEmail())
						|| (this.getTeacherEmail() != null && castOther.getTeacherEmail() != null
								&& this.getTeacherEmail().equals(castOther.getTeacherEmail())))
				&& ((this.getSemesterNo() == castOther.getSemesterNo()) || (this.getSemesterNo() != null
						&& castOther.getSemesterNo() != null && this.getSemesterNo().equals(castOther.getSemesterNo())))
				&& ((this.getSemesterName() == castOther.getSemesterName())
						|| (this.getSemesterName() != null && castOther.getSemesterName() != null
								&& this.getSemesterName().equals(castOther.getSemesterName())))
				&& ((this.getStartWeek() == castOther.getStartWeek()) || (this.getStartWeek() != null
						&& castOther.getStartWeek() != null && this.getStartWeek().equals(castOther.getStartWeek())))
				&& ((this.getEndWeek() == castOther.getEndWeek()) || (this.getEndWeek() != null
						&& castOther.getEndWeek() != null && this.getEndWeek().equals(castOther.getEndWeek())))
				&& ((this.getIsCurrentSemester() == castOther.getIsCurrentSemester())
						|| (this.getIsCurrentSemester() != null && castOther.getIsCurrentSemester() != null
								&& this.getIsCurrentSemester().equals(castOther.getIsCurrentSemester())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getCourseNo() == null ? 0 : this.getCourseNo().hashCode());
		result = 37 * result + (getCourseName() == null ? 0 : this.getCourseName().hashCode());
		result = 37 * result + (getCourseAcademy() == null ? 0 : this.getCourseAcademy().hashCode());
		result = 37 * result + (getCourseCategory() == null ? 0 : this.getCourseCategory().hashCode());
		result = 37 * result + (getTeacherNo() == null ? 0 : this.getTeacherNo().hashCode());
		result = 37 * result + (getTeacherName() == null ? 0 : this.getTeacherName().hashCode());
		result = 37 * result + (getTeacherAcademy() == null ? 0 : this.getTeacherAcademy().hashCode());
		result = 37 * result + (getTeacherTitle() == null ? 0 : this.getTeacherTitle().hashCode());
		result = 37 * result + (getTeacherEmail() == null ? 0 : this.getTeacherEmail().hashCode());
		result = 37 * result + (getSemesterNo() == null ? 0 : this.getSemesterNo().hashCode());
		result = 37 * result + (getSemesterName() == null ? 0 : this.getSemesterName().hashCode());
		result = 37 * result + (getStartWeek() == null ? 0 : this.getStartWeek().hashCode());
		result = 37 * result + (getEndWeek() == null ? 0 : this.getEndWeek().hashCode());
		result = 37 * result + (getIsCurrentSemester() == null ? 0 : this.getIsCurrentSemester().hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "SelectedCourseViewId [courseNo=" + courseNo + ", courseName=" + courseName + ", courseAcademy="
				+ courseAcademy + ", courseCategory=" + courseCategory + ", teacherNo=" + teacherNo + ", teacherName="
				+ teacherName + ", teacherAcademy=" + teacherAcademy + ", teacherTitle=" + teacherTitle
				+ ", teacherEmail=" + teacherEmail + ", semesterNo=" + semesterNo + ", semesterName=" + semesterName
				+ ", startWeek=" + startWeek + ", endWeek=" + endWeek + ", isCurrentSemester=" + isCurrentSemester
				+ "]";
	}

}