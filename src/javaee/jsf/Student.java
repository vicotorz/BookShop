package javaee.jsf;

import javaee.jsf.ejb.DBop;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

//定义托管BeanStudent，与项目的JSF页面相关联，且作用域为SessionScoped
@ManagedBean
@SessionScoped
public class Student {
	private String name;
	private String password;

	// ע��EJB
	@EJB
	DBop db;

	public Student() {
	}

	public String getName() {
		return name;
	}

	public void setName(String newValue) {
		name = newValue;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String newValue) {
		password = newValue;
	}

	public String VerifyPassword() {
		boolean flag = db.findName_pwd(this.name, this.password);
		if (flag) {
			return "success";
		} else
			return "failure";
	}

	public String forgetPassword() {
		return "success";
	}
}
