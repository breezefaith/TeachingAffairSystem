package teaching.affair.system.pojo.view;

/**
 * SelectCourseResultView entity. @author MyEclipse Persistence Tools
 */

public class SelectCourseResultView implements java.io.Serializable {

	// Fields

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
		SelectCourseResultView other = (SelectCourseResultView) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	private SelectCourseResultViewId id;

	// Constructors

	/** default constructor */
	public SelectCourseResultView() {
	}

	/** full constructor */
	public SelectCourseResultView(SelectCourseResultViewId id) {
		this.id = id;
	}

	// Property accessors

	public SelectCourseResultViewId getId() {
		return this.id;
	}

	public void setId(SelectCourseResultViewId id) {
		this.id = id;
	}

}