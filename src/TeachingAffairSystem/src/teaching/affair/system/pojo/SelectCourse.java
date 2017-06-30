package teaching.affair.system.pojo;

/**
 * SelectCourse entity. @author MyEclipse Persistence Tools
 */

public class SelectCourse implements java.io.Serializable {

	// Fields

	private Integer selectCourseNo;
	private String studentNo;
	private Integer semesterCourseNo;
	private Integer score;

	// Constructors

	/** default constructor */
	public SelectCourse() {
	}

	/** full constructor */
	public SelectCourse(String studentNo, Integer semesterCourseNo, Integer score) {
		this.studentNo = studentNo;
		this.semesterCourseNo = semesterCourseNo;
		this.score = score;
	}

	// Property accessors

	public Integer getSelectCourseNo() {
		return this.selectCourseNo;
	}

	public void setSelectCourseNo(Integer selectCourseNo) {
		this.selectCourseNo = selectCourseNo;
	}

	public String getStudentNo() {
		return this.studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public Integer getSemesterCourseNo() {
		return this.semesterCourseNo;
	}

	public void setSemesterCourseNo(Integer semesterCourseNo) {
		this.semesterCourseNo = semesterCourseNo;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((score == null) ? 0 : score.hashCode());
		result = prime * result + ((selectCourseNo == null) ? 0 : selectCourseNo.hashCode());
		result = prime * result + ((semesterCourseNo == null) ? 0 : semesterCourseNo.hashCode());
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
		SelectCourse other = (SelectCourse) obj;
		if (score == null) {
			if (other.score != null)
				return false;
		} else if (!score.equals(other.score))
			return false;
		if (selectCourseNo == null) {
			if (other.selectCourseNo != null)
				return false;
		} else if (!selectCourseNo.equals(other.selectCourseNo))
			return false;
		if (semesterCourseNo == null) {
			if (other.semesterCourseNo != null)
				return false;
		} else if (!semesterCourseNo.equals(other.semesterCourseNo))
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
		return "SelectCourse [selectCourseNo=" + selectCourseNo + ", studentNo=" + studentNo + ", semesterCourseNo="
				+ semesterCourseNo + ", score=" + score + "]";
	}

}