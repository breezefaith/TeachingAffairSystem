package teaching.affair.system.pojo.view;

/**
 * SelectCourseResultViewId entity. @author MyEclipse Persistence Tools
 */

public class SelectCourseResultViewId implements java.io.Serializable {

	// Fields

	private String studentNo;
	@Override
	public String toString() {
		return "SelectCourseResultViewId [studentNo=" + studentNo + ", studentName=" + studentName + ", studentAcademy="
				+ studentAcademy + ", studentMajor=" + studentMajor + ", studentClass=" + studentClass + ", teacherNo="
				+ teacherNo + ", teacherName=" + teacherName + ", teacherAcademy=" + teacherAcademy + ", teacherTitle="
				+ teacherTitle + ", teacherEmail=" + teacherEmail + ", courseNo=" + courseNo + ", courseName="
				+ courseName + ", courseAcademy=" + courseAcademy + ", courseCategory=" + courseCategory
				+ ", startWeek=" + startWeek + ", endWeek=" + endWeek + ", semesterNo=" + semesterNo + ", semesterName="
				+ semesterName + ", score=" + score + "]";
	}

	private String studentName;
	private String studentAcademy;
	private String studentMajor;
	private Integer studentClass;
	private String teacherNo;
	private String teacherName;
	private String teacherAcademy;
	private String teacherTitle;
	private String teacherEmail;
	private String courseNo;
	private String courseName;
	private String courseAcademy;
	private String courseCategory;
	private Integer startWeek;
	private Integer endWeek;
	private Integer semesterNo;
	private String semesterName;
	private Integer score;

	// Constructors

	/** default constructor */
	public SelectCourseResultViewId() {
	}

	/** minimal constructor */
	public SelectCourseResultViewId(String studentNo, String teacherNo, String courseNo, String courseName,
			Integer startWeek, Integer endWeek, Integer semesterNo, String semesterName) {
		this.studentNo = studentNo;
		this.teacherNo = teacherNo;
		this.courseNo = courseNo;
		this.courseName = courseName;
		this.startWeek = startWeek;
		this.endWeek = endWeek;
		this.semesterNo = semesterNo;
		this.semesterName = semesterName;
	}

	/** full constructor */
	public SelectCourseResultViewId(String studentNo, String studentName, String studentAcademy, String studentMajor,
			Integer studentClass, String teacherNo, String teacherName, String teacherAcademy, String teacherTitle,
			String teacherEmail, String courseNo, String courseName, String courseAcademy, String courseCategory,
			Integer startWeek, Integer endWeek, Integer semesterNo, String semesterName, Integer score) {
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.studentAcademy = studentAcademy;
		this.studentMajor = studentMajor;
		this.studentClass = studentClass;
		this.teacherNo = teacherNo;
		this.teacherName = teacherName;
		this.teacherAcademy = teacherAcademy;
		this.teacherTitle = teacherTitle;
		this.teacherEmail = teacherEmail;
		this.courseNo = courseNo;
		this.courseName = courseName;
		this.courseAcademy = courseAcademy;
		this.courseCategory = courseCategory;
		this.startWeek = startWeek;
		this.endWeek = endWeek;
		this.semesterNo = semesterNo;
		this.semesterName = semesterName;
		this.score = score;
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

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SelectCourseResultViewId))
			return false;
		SelectCourseResultViewId castOther = (SelectCourseResultViewId) other;

		return ((this.getStudentNo() == castOther.getStudentNo()) || (this.getStudentNo() != null
				&& castOther.getStudentNo() != null && this.getStudentNo().equals(castOther.getStudentNo())))
				&& ((this.getStudentName() == castOther.getStudentName())
						|| (this.getStudentName() != null && castOther.getStudentName() != null
								&& this.getStudentName().equals(castOther.getStudentName())))
				&& ((this.getStudentAcademy() == castOther.getStudentAcademy())
						|| (this.getStudentAcademy() != null && castOther.getStudentAcademy() != null
								&& this.getStudentAcademy().equals(castOther.getStudentAcademy())))
				&& ((this.getStudentMajor() == castOther.getStudentMajor())
						|| (this.getStudentMajor() != null && castOther.getStudentMajor() != null
								&& this.getStudentMajor().equals(castOther.getStudentMajor())))
				&& ((this.getStudentClass() == castOther.getStudentClass())
						|| (this.getStudentClass() != null && castOther.getStudentClass() != null
								&& this.getStudentClass().equals(castOther.getStudentClass())))
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
				&& ((this.getCourseNo() == castOther.getCourseNo()) || (this.getCourseNo() != null
						&& castOther.getCourseNo() != null && this.getCourseNo().equals(castOther.getCourseNo())))
				&& ((this.getCourseName() == castOther.getCourseName()) || (this.getCourseName() != null
						&& castOther.getCourseName() != null && this.getCourseName().equals(castOther.getCourseName())))
				&& ((this.getCourseAcademy() == castOther.getCourseAcademy())
						|| (this.getCourseAcademy() != null && castOther.getCourseAcademy() != null
								&& this.getCourseAcademy().equals(castOther.getCourseAcademy())))
				&& ((this.getCourseCategory() == castOther.getCourseCategory())
						|| (this.getCourseCategory() != null && castOther.getCourseCategory() != null
								&& this.getCourseCategory().equals(castOther.getCourseCategory())))
				&& ((this.getStartWeek() == castOther.getStartWeek()) || (this.getStartWeek() != null
						&& castOther.getStartWeek() != null && this.getStartWeek().equals(castOther.getStartWeek())))
				&& ((this.getEndWeek() == castOther.getEndWeek()) || (this.getEndWeek() != null
						&& castOther.getEndWeek() != null && this.getEndWeek().equals(castOther.getEndWeek())))
				&& ((this.getSemesterNo() == castOther.getSemesterNo()) || (this.getSemesterNo() != null
						&& castOther.getSemesterNo() != null && this.getSemesterNo().equals(castOther.getSemesterNo())))
				&& ((this.getSemesterName() == castOther.getSemesterName())
						|| (this.getSemesterName() != null && castOther.getSemesterName() != null
								&& this.getSemesterName().equals(castOther.getSemesterName())))
				&& ((this.getScore() == castOther.getScore()) || (this.getScore() != null
						&& castOther.getScore() != null && this.getScore().equals(castOther.getScore())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getStudentNo() == null ? 0 : this.getStudentNo().hashCode());
		result = 37 * result + (getStudentName() == null ? 0 : this.getStudentName().hashCode());
		result = 37 * result + (getStudentAcademy() == null ? 0 : this.getStudentAcademy().hashCode());
		result = 37 * result + (getStudentMajor() == null ? 0 : this.getStudentMajor().hashCode());
		result = 37 * result + (getStudentClass() == null ? 0 : this.getStudentClass().hashCode());
		result = 37 * result + (getTeacherNo() == null ? 0 : this.getTeacherNo().hashCode());
		result = 37 * result + (getTeacherName() == null ? 0 : this.getTeacherName().hashCode());
		result = 37 * result + (getTeacherAcademy() == null ? 0 : this.getTeacherAcademy().hashCode());
		result = 37 * result + (getTeacherTitle() == null ? 0 : this.getTeacherTitle().hashCode());
		result = 37 * result + (getTeacherEmail() == null ? 0 : this.getTeacherEmail().hashCode());
		result = 37 * result + (getCourseNo() == null ? 0 : this.getCourseNo().hashCode());
		result = 37 * result + (getCourseName() == null ? 0 : this.getCourseName().hashCode());
		result = 37 * result + (getCourseAcademy() == null ? 0 : this.getCourseAcademy().hashCode());
		result = 37 * result + (getCourseCategory() == null ? 0 : this.getCourseCategory().hashCode());
		result = 37 * result + (getStartWeek() == null ? 0 : this.getStartWeek().hashCode());
		result = 37 * result + (getEndWeek() == null ? 0 : this.getEndWeek().hashCode());
		result = 37 * result + (getSemesterNo() == null ? 0 : this.getSemesterNo().hashCode());
		result = 37 * result + (getSemesterName() == null ? 0 : this.getSemesterName().hashCode());
		result = 37 * result + (getScore() == null ? 0 : this.getScore().hashCode());
		return result;
	}

}