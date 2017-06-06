package javaee.jsf;

import javaee.jsf.StuEntities.StudentEO;
import javaee.jsf.ejb.DBop;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class registerBean {

	private String name;
	private String password;

	@EJB
	DBop db;

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

	public registerBean() {
		super();
	}

	public String gotomain() {
		int id = db.getid() + 1;// 用笨方法生成主键
		boolean flag = db.addNewStudent(new StudentEO(id, this.name,
				this.password, "1"));
		// true用户名不重复
		// false用户名重复
		if (flag) {
			return "main";
		} else {
			return "stay";
		}
	}
}
