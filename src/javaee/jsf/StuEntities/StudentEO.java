package javaee.jsf.StuEntities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
// 实体Bean StudentEO用来构造与数据库中的表students的映射
@Table(name = "w_user")
@NamedQueries({
		@NamedQuery(name = "findAlluser", query = "SELECT l "
				+ "FROM StudentEO l"),

		@NamedQuery(name = "finduserByName", query = "SELECT DISTINCT l FROM StudentEO l "
				+ " WHERE l.name = :username"),

		@NamedQuery(name = "findusertByID", query = "SELECT DISTINCT l FROM StudentEO l "
				+ " WHERE l.id = :userid"),

		@NamedQuery(name = "findname_pwd", query = "SELECT DISTINCT l FROM StudentEO l "
				+ "WHERE l.name=:username and l.password=:password")

}

)
public class StudentEO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)//不太好使，而且不会用
	@Column(name = "id", unique = true)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "password")
	private String password;

	@Column(name = "level")
	private String level;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public StudentEO(int id, String name, String password, String level) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.level = level;
	}

	public StudentEO() {
		super();
	}
}