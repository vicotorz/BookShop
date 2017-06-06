package javaee.jsf;

import java.util.List;

import javaee.jsf.StuEntities.StudentEO;
import javaee.jsf.ejb.DBop;

/*import javax.annotation.ManagedBean;*///这里出现了错误
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@SessionScoped
public class fetchBean {

	private String name;
	private String password;

	@EJB
	DBop db;

	public fetchBean() {
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

	// 编写查找遗忘的用户名方法
	public String checkName() {
		List<StudentEO> users = db.regetuser(this.name);
		this.password = users.get(users.size() - 1).getPassword();

		System.out.println(this.name);
		System.out.println(this.password);

		if (users.size() != 0) {
			return "Yes";
		} else
			return "No";

	}
}
