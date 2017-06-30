package teaching.affair.system.pojo;

import java.util.Date;

/**
 * Semester entity. @author MyEclipse Persistence Tools
 */

public class Semester implements java.io.Serializable {

	// Fields

	private Integer semesterNo;
	private String semesterName;
	private Date startDate;
	private Date endDate;

	// Constructors

	/** default constructor */
	public Semester() {
	}

	/** full constructor */
	public Semester(String semesterName, Date startDate, Date endDate) {
		this.semesterName = semesterName;
		this.startDate = startDate;
		this.endDate = endDate;
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

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((semesterName == null) ? 0 : semesterName.hashCode());
		result = prime * result + ((semesterNo == null) ? 0 : semesterNo.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
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
		Semester other = (Semester) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (semesterName == null) {
			if (other.semesterName != null)
				return false;
		} else if (!semesterName.equals(other.semesterName))
			return false;
		if (semesterNo == null) {
			if (other.semesterNo != null)
				return false;
		} else if (!semesterNo.equals(other.semesterNo))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Semester [semesterNo=" + semesterNo + ", semesterName=" + semesterName + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}

}