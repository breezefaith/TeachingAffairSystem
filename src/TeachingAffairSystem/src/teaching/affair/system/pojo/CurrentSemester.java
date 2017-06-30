package teaching.affair.system.pojo;

/**
 * CurrentSemester entity. @author MyEclipse Persistence Tools
 */

public class CurrentSemester implements java.io.Serializable {

	// Fields

	private Integer currentSemesteId;
	private Integer semesterNo;

	// Constructors

	/** default constructor */
	public CurrentSemester() {
	}

	/** minimal constructor */
	public CurrentSemester(Integer currentSemesteId) {
		this.currentSemesteId = currentSemesteId;
	}

	/** full constructor */
	public CurrentSemester(Integer currentSemesteId, Integer semesterNo) {
		this.currentSemesteId = currentSemesteId;
		this.semesterNo = semesterNo;
	}

	// Property accessors

	public Integer getCurrentSemesteId() {
		return this.currentSemesteId;
	}

	public void setCurrentSemesteId(Integer currentSemesteId) {
		this.currentSemesteId = currentSemesteId;
	}

	public Integer getSemesterNo() {
		return this.semesterNo;
	}

	public void setSemesterNo(Integer semesterNo) {
		this.semesterNo = semesterNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currentSemesteId == null) ? 0 : currentSemesteId.hashCode());
		result = prime * result + ((semesterNo == null) ? 0 : semesterNo.hashCode());
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
		CurrentSemester other = (CurrentSemester) obj;
		if (currentSemesteId == null) {
			if (other.currentSemesteId != null)
				return false;
		} else if (!currentSemesteId.equals(other.currentSemesteId))
			return false;
		if (semesterNo == null) {
			if (other.semesterNo != null)
				return false;
		} else if (!semesterNo.equals(other.semesterNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CurrentSemester [currentSemesteId=" + currentSemesteId + ", semesterNo=" + semesterNo + "]";
	}

}