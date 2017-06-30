package teaching.affair.system.pojo.view;

/**
 * SelectedCourseView entity. @author MyEclipse Persistence Tools
 */

public class SelectedCourseView implements java.io.Serializable {

	// Fields

	private SelectedCourseViewId id;

	// Constructors

	/** default constructor */
	public SelectedCourseView() {
	}

	/** full constructor */
	public SelectedCourseView(SelectedCourseViewId id) {
		this.id = id;
	}

	// Property accessors

	public SelectedCourseViewId getId() {
		return this.id;
	}

	public void setId(SelectedCourseViewId id) {
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
		SelectedCourseView other = (SelectedCourseView) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SelectedCourseView [id=" + id + "]";
	}

}