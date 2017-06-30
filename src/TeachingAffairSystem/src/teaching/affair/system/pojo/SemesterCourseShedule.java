package teaching.affair.system.pojo;

/**
 * SemesterCourseShedule entity. @author MyEclipse Persistence Tools
 */

public class SemesterCourseShedule implements java.io.Serializable {

	// Fields

	private SemesterCourseSheduleId id;
	private Integer startClassNo;
	private Integer endClassNo;

	// Constructors

	/** default constructor */
	public SemesterCourseShedule() {
	}

	/** full constructor */
	public SemesterCourseShedule(SemesterCourseSheduleId id, Integer startClassNo, Integer endClassNo) {
		this.id = id;
		this.startClassNo = startClassNo;
		this.endClassNo = endClassNo;
	}

	// Property accessors

	public SemesterCourseSheduleId getId() {
		return this.id;
	}

	public void setId(SemesterCourseSheduleId id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endClassNo == null) ? 0 : endClassNo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((startClassNo == null) ? 0 : startClassNo.hashCode());
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
		SemesterCourseShedule other = (SemesterCourseShedule) obj;
		if (endClassNo == null) {
			if (other.endClassNo != null)
				return false;
		} else if (!endClassNo.equals(other.endClassNo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (startClassNo == null) {
			if (other.startClassNo != null)
				return false;
		} else if (!startClassNo.equals(other.startClassNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SemesterCourseShedule [id=" + id + ", startClassNo=" + startClassNo + ", endClassNo=" + endClassNo
				+ "]";
	}

}