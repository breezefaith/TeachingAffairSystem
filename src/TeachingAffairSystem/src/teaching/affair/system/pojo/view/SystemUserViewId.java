package teaching.affair.system.pojo.view;

/**
 * SystemUserViewId entity. @author MyEclipse Persistence Tools
 */

public class SystemUserViewId implements java.io.Serializable {

	// Fields

	private String username;
	private String password;
	private String identity;

	// Constructors

	/** default constructor */
	public SystemUserViewId() {
	}

	/** minimal constructor */
	public SystemUserViewId(String username, String identity) {
		this.username = username;
		this.identity = identity;
	}

	/** full constructor */
	public SystemUserViewId(String username, String password, String identity) {
		this.username = username;
		this.password = password;
		this.identity = identity;
	}

	// Property accessors

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdentity() {
		return this.identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SystemUserViewId))
			return false;
		SystemUserViewId castOther = (SystemUserViewId) other;

		return ((this.getUsername() == castOther.getUsername()) || (this.getUsername() != null
				&& castOther.getUsername() != null && this.getUsername().equals(castOther.getUsername())))
				&& ((this.getPassword() == castOther.getPassword()) || (this.getPassword() != null
						&& castOther.getPassword() != null && this.getPassword().equals(castOther.getPassword())))
				&& ((this.getIdentity() == castOther.getIdentity()) || (this.getIdentity() != null
						&& castOther.getIdentity() != null && this.getIdentity().equals(castOther.getIdentity())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUsername() == null ? 0 : this.getUsername().hashCode());
		result = 37 * result + (getPassword() == null ? 0 : this.getPassword().hashCode());
		result = 37 * result + (getIdentity() == null ? 0 : this.getIdentity().hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "SystemUserViewId [username=" + username + ", password=" + password + ", identity=" + identity + "]";
	}

}