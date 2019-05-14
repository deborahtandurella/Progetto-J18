package magazinestore.entity;
// Generated 27-apr-2019 19.55.30 by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Utenti generated by hbm2java
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Utenti u ORDER BY u.fullName"),
    @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Utenti u WHERE u.email = :email"),
    @NamedQuery(name = "Users.countAll", query = "SELECT Count(*) FROM Utenti u"),
    @NamedQuery(name = "Users.checkLogin", query = "SELECT u FROM Utenti u WHERE u.email = :email AND password = :password")

})
@Table(name = "utenti", catalog = "magazinestoredb")
public class Utenti implements java.io.Serializable {

	private Integer userId;
	private String email;
	private String password;
	private String fullName;

	public Utenti() {
	}

	public Utenti(Integer userId, String email, String fullName, String password) {
		this(email, fullName, password);
		this.userId = userId;
	}

	public Utenti(String email, String fullName, String password) {
		this.email = email;
		this.fullName = fullName;
		this.password = password;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "email", nullable = false, length = 30)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = false, length = 16)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "full_name", nullable = false, length = 30)
	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}