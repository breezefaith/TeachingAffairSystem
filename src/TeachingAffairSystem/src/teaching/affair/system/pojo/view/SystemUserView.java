package teaching.affair.system.pojo.view;

/**
 * SystemUserView entity. @author MyEclipse Persistence Tools
 */

public class SystemUserView implements java.io.Serializable {

	// Fields

	private SystemUserViewId id;

	// Constructors

	/** default constructor */
	public SystemUserView() {
	}

	/** full constructor */
	public SystemUserView(SystemUserViewId id) {
		this.id = id;
	}

	// Property accessors

	public SystemUserViewId getId() {
		return this.id;
	}

	public void setId(SystemUserViewId id) {
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
		SystemUserView other = (SystemUserView) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SystemUserView [id=" + id + "]";
	}

}