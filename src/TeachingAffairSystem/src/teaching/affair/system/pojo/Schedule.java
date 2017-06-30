package teaching.affair.system.pojo;

import java.util.Date;

/**
 * Schedule entity. @author MyEclipse Persistence Tools
 */

public class Schedule implements java.io.Serializable {

	// Fields

	private Integer classNo;
	private Date startClassTime;
	private Date endClassTime;

	// Constructors

	/** default constructor */
	public Schedule() {
	}

	/** full constructor */
	public Schedule(Integer classNo, Date startClassTime, Date endClassTime) {
		this.classNo = classNo;
		this.startClassTime = startClassTime;
		this.endClassTime = endClassTime;
	}

	// Property accessors

	public Integer getClassNo() {
		return this.classNo;
	}

	public void setClassNo(Integer classNo) {
		this.classNo = classNo;
	}

	public Date getStartClassTime() {
		return this.startClassTime;
	}

	public void setStartClassTime(Date startClassTime) {
		this.startClassTime = startClassTime;
	}

	public Date getEndClassTime() {
		return this.endClassTime;
	}

	public void setEndClassTime(Date endClassTime) {
		this.endClassTime = endClassTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classNo == null) ? 0 : classNo.hashCode());
		result = prime * result + ((endClassTime == null) ? 0 : endClassTime.hashCode());
		result = prime * result + ((startClassTime == null) ? 0 : startClassTime.hashCode());
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
		Schedule other = (Schedule) obj;
		if (classNo == null) {
			if (other.classNo != null)
				return false;
		} else if (!classNo.equals(other.classNo))
			return false;
		if (endClassTime == null) {
			if (other.endClassTime != null)
				return false;
		} else if (!endClassTime.equals(other.endClassTime))
			return false;
		if (startClassTime == null) {
			if (other.startClassTime != null)
				return false;
		} else if (!startClassTime.equals(other.startClassTime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Schedule [classNo=" + classNo + ", startClassTime=" + startClassTime + ", endClassTime=" + endClassTime
				+ "]";
	}

}