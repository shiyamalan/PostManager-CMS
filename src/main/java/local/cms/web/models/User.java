package local.cms.web.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/***
 * User entity with users table
 * 
 * @author shiyam User Entity Class with table name users
 * @since 1.0.0
 * @version 1.0.0
 */
@Entity
@Table(name = "users")
public class User {

	@Id
	private String username;
	private String password;
	@Column(name = "enabled")
	private boolean isEnabled = true;

	@Id
	@Column(name = "username", nullable = false)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "enabled", nullable = false)
	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean enabled) {
		isEnabled = enabled;
	}

}
