package javaee.jsf;

import java.util.*;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

public class TableBean {
	private DataModel model;
	private int rowIndex = -1;

	public DataModel getUsers() {
		if (model == null) {
			model = new ListDataModel();
			model.setWrappedData(getUserList());
		}

		return model;
	}

	// 私有方法，页面无法绑定
	private List<User> getUserList() {
		List<User> userList = new ArrayList<User>();
		userList.add(new User("张三", "123456"));
		userList.add(new User("李四", "123456"));
		userList.add(new User("王五", "123456"));

		return userList;
	}

	public int getSelectedRowIndex() {
		return rowIndex;
	}

	public String select() {
		rowIndex = model.getRowIndex();
		return "success";
	}
}