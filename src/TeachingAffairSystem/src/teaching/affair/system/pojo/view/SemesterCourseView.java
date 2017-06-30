package teaching.affair.system.pojo.view;

/**
 * SemesterCourseView entity. @author MyEclipse Persistence Tools
 */

public class SemesterCourseView implements java.io.Serializable {

	// Fields

	private SemesterCourseViewId id;

	// Constructors

	/** default constructor */
	public SemesterCourseView() {
	}

	/** full constructor */
	public SemesterCourseView(SemesterCourseViewId id) {
		this.id = id;
	}

	// Property accessors

	public SemesterCourseViewId getId() {
		return this.id;
	}

	public void setId(SemesterCourseViewId id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		SemesterCourseView other = (SemesterCourseView) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SemesterCourseView [id=" + id + "]";
	}

}