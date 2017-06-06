package javaee.jsf.StuEntities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
//对应test里的表
@Entity
@Table(name = "w_book")
@NamedQueries({
		@NamedQuery(name = "findAllbook", query = "SELECT l " + "FROM book l"),

		@NamedQuery(name = "findbookByName", query = "SELECT DISTINCT l FROM book l "
				+ " WHERE l.name = :username"),

		@NamedQuery(name = "findbooktByID", query = "SELECT DISTINCT l FROM book l "
				+ " WHERE l.id = :userid") }

)
public class book {
	@Id
	@Column(name = "b_id", unique = true)
	private int id;// ͼ������
	@Column(name = "b_name")
	private String name;// ͼ�����
	@Column(name = "b_lev")
	private String lev;// ͼ��ķ�����Ϣ
	@Column(name = "b_money")
	private String money;
	@Column(name = "b_info")
	private String info;// ��עͼ����Ϣ
	@Column(name = "b_number")
	private String number;// ���

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

	public String getLev() {
		return lev;
	}

	public void setLev(String lev) {
		this.lev = lev;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public book(int id, String name, String lev, String money, String info,
			String number) {
		super();
		this.id = id;
		this.name = name;
		this.lev = lev;
		this.money = money;
		this.info = info;
		this.number = number;
	}

	public book() {
		super();
	}

}
