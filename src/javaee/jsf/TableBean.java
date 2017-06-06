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

	// ˽�з�����ҳ���޷���
	private List<User> getUserList() {
		List<User> userList = new ArrayList<User>();
		userList.add(new User("����", "123456"));
		userList.add(new User("����", "123456"));
		userList.add(new User("����", "123456"));

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