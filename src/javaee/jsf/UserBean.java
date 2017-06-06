package javaee.jsf;

import java.util.List;

import javaee.jsf.StuEntities.book;
import javaee.jsf.ejb.DBop;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UserBean {

	private String name;
	private String password;
	private List<book> books = null;

	@EJB
	DBop db;

	// --------处理表格部分（网上的实例）--------------
	// 试一试
	/*
	 * private DataModel model; private int rowIndex = -1;
	 * 
	 * public DataModel getUsers() { if (model == null) { model = new
	 * ListDataModel(); model.setWrappedData(getbooks()); //
	 * 将装有用户的list放入setWrappedData中 } return model; }
	 * 
	 * // public int getSelectedRowIndex() { return rowIndex; }
	 * 
	 * public String select() { rowIndex = model.getRowIndex(); return
	 * "success"; }
	 */

	// --------以上表的处理结束--------------
	public List<book> getBooks() {
		return books;
	}

	public List<book> getbooks() {
		// DBop op= new DBop();
		return db.findAllbook();
	}

	public void setBooks(List<book> books) {
		this.books = books;
	}

	public UserBean() {
		// 不能初始赋值
		// this.books = getbooks();
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
		System.out.println("已确定用户身份，需要加载图书");
		boolean flag = db.findName_pwd(this.name, this.password);
		if (flag) {
			// 已确定用户身份，需要加载图书
			System.out.println("已确定用户身份，需要加载图书");
			System.out.println(db.findAllbook().size());
			setBooks(db.findAllbook());
			System.out.println("看好了给你的books" + this.books.size());
			return "success";
		} else
			return "failure";
	}

	public String forgetPassword() {
		return "fetch";
	}

	public String adduser() {
		return "add";
	}

}