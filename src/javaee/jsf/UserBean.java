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

	// --------�����񲿷֣����ϵ�ʵ����--------------
	// ��һ��
	/*
	 * private DataModel model; private int rowIndex = -1;
	 * 
	 * public DataModel getUsers() { if (model == null) { model = new
	 * ListDataModel(); model.setWrappedData(getbooks()); //
	 * ��װ���û���list����setWrappedData�� } return model; }
	 * 
	 * // public int getSelectedRowIndex() { return rowIndex; }
	 * 
	 * public String select() { rowIndex = model.getRowIndex(); return
	 * "success"; }
	 */

	// --------���ϱ�Ĵ������--------------
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
		// ���ܳ�ʼ��ֵ
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
		System.out.println("��ȷ���û���ݣ���Ҫ����ͼ��");
		boolean flag = db.findName_pwd(this.name, this.password);
		if (flag) {
			// ��ȷ���û���ݣ���Ҫ����ͼ��
			System.out.println("��ȷ���û���ݣ���Ҫ����ͼ��");
			System.out.println(db.findAllbook().size());
			setBooks(db.findAllbook());
			System.out.println("�����˸����books" + this.books.size());
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