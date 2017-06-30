package teaching.affair.system.pojo;

/**
 * SemesterCourse entity. @author MyEclipse Persistence Tools
 */

public class SemesterCourse implements java.io.Serializable {

	// Fields

	private Integer semesterCourseNo;
	private Integer semesterNo;
	private String courseNo;
	private String teacherNo;
	private Integer startWeek;
	private Integer endWeek;
	private Integer expectNum;

	// Constructors

	/** default constructor */
	public SemesterCourse() {
	}

	/** minimal constructor */
	public SemesterCourse(Integer startWeek, Integer endWeek, Integer expectNum) {
		this.startWeek = startWeek;
		this.endWeek = endWeek;
		this.expectNum = expectNum;
	}

	/** full constructor */
	public SemesterCourse(Integer semesterNo, String courseNo, String teacherNo, Integer startWeek, Integer endWeek,
			Integer expectNum) {
		this.semesterNo = semesterNo;
		this.courseNo = courseNo;
		this.teacherNo = teacherNo;
		this.startWeek = startWeek;
		this.endWeek = endWeek;
		this.expectNum = expectNum;
	}

	// Property accessors

	public Integer getSemesterCourseNo() {
		return this.semesterCourseNo;
	}

	public void setSemesterCourseNo(Integer semesterCourseNo) {
		this.semesterCourseNo = semesterCourseNo;
	}

	public Integer getSemesterNo() {
		return this.semesterNo;
	}

	public void setSemesterNo(Integer semesterNo) {
		this.semesterNo = semesterNo;
	}

	public String getCourseNo() {
		return this.courseNo;
	}

	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}

	public String getTeacherNo() {
		return this.teacherNo;
	}

	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
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

	public Integer getExpectNum() {
		return this.expectNum;
	}

	public void setExpectNum(Integer expectNum) {
		this.expectNum = expectNum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseNo == null) ? 0 : courseNo.hashCode());
		result = prime * result + ((endWeek == null) ? 0 : endWeek.hashCode());
		result = prime * result + ((expectNum == null) ? 0 : expectNum.hashCode());
		result = prime * result + ((semesterCourseNo == null) ? 0 : semesterCourseNo.hashCode());
		result = prime * result + ((semesterNo == null) ? 0 : semesterNo.hashCode());
		result = prime * result + ((startWeek == null) ? 0 : startWeek.hashCode());
		result = prime * result + ((teacherNo == null) ? 0 : teacherNo.hashCode());
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
		SemesterCourse other = (SemesterCourse) obj;
		if (courseNo == null) {
			if (other.courseNo != null)
				return false;
		} else if (!courseNo.equals(other.courseNo))
			return false;
		if (endWeek == null) {
			if (other.endWeek != null)
				return false;
		} else if (!endWeek.equals(other.endWeek))
			return false;
		if (expectNum == null) {
			if (other.expectNum != null)
				return false;
		} else if (!expectNum.equals(other.expectNum))
			return false;
		if (semesterCourseNo == null) {
			if (other.semesterCourseNo != null)
				return false;
		} else if (!semesterCourseNo.equals(other.semesterCourseNo))
			return false;
		if (semesterNo == null) {
			if (other.semesterNo != null)
				return false;
		} else if (!semesterNo.equals(other.semesterNo))
			return false;
		if (startWeek == null) {
			if (other.startWeek != null)
				return false;
		} else if (!startWeek.equals(other.startWeek))
			return false;
		if (teacherNo == null) {
			if (other.teacherNo != null)
				return false;
		} else if (!teacherNo.equals(other.teacherNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SemesterCourse [semesterCourseNo=" + semesterCourseNo + ", semesterNo=" + semesterNo + ", courseNo="
				+ courseNo + ", teacherNo=" + teacherNo + ", startWeek=" + startWeek + ", endWeek=" + endWeek
				+ ", expectNum=" + expectNum + "]";
	}

}