package teaching.affair.system.pojo.view;

/**
 * CurrentSemesterSchduleView entity. @author MyEclipse Persistence Tools
 */

public class CurrentSemesterSchduleView implements java.io.Serializable {

	// Fields

	private CurrentSemesterSchduleViewId id;

	// Constructors

	/** default constructor */
	public CurrentSemesterSchduleView() {
	}

	/** full constructor */
	public CurrentSemesterSchduleView(CurrentSemesterSchduleViewId id) {
		this.id = id;
	}

	// Property accessors

	public CurrentSemesterSchduleViewId getId() {
		return this.id;
	}

	public void setId(CurrentSemesterSchduleViewId id) {
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
		CurrentSemesterSchduleView other = (CurrentSemesterSchduleView) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CurrentSemesterSchduleView [id=" + id + "]";
	}

}