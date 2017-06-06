package javaee.jsf.ejb;

import java.util.List;

import javaee.jsf.StuEntities.StudentEO;
import javaee.jsf.StuEntities.book;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

//构造了一个 无状态会话Bean，实现实体的各种操作
@Stateless
public class DBop {
	// @PersistenceContext用来以标注的方式注入一个实体管理器，其中的“jsf_example”是在persistence.xml中定义的持久化单元的名字
	@PersistenceContext(unitName = "jsf_example")
	private EntityManager em;

	public DBop() {

	}

	// 运行在实体BeanStudentEO中定义的查询"findAllStudent"来取出所有的学生数据
	public List<StudentEO> getAllStudent() {
		@SuppressWarnings("unchecked")
		List<StudentEO> Students = em.createNamedQuery("findAlluser")
				.getResultList();
		return Students;
	}

	// 得到最大的id值
	public int getid() {
		List<StudentEO> list = getAllStudent();
		if (list.size() == 0) {
			return 0;
		} else {
			return list.get(list.size() - 1).getId();
		}

	}

	// 运行在实体BeanStudentEO中定义的查询"findStudentByID"来按学号查找一个学生
	public StudentEO findStudent(Integer pStuID) {
		@SuppressWarnings("unchecked")
		List<StudentEO> tStuList = em.createNamedQuery("finduserByID")
				.setParameter("studentNum", pStuID).getResultList();
		return tStuList.get(0);
	}

	// 查找有关用户名的方法
	public boolean findName(String name) {
		Query query = em.createNamedQuery("finduserByName").setParameter(
				"username", name);
		@SuppressWarnings("unchecked")
		List<StudentEO> users = query.getResultList();
		if (users.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	public List<StudentEO> regetuser(String name) {
		Query query = em.createNamedQuery("finduserByName").setParameter(
				"username", name);
		@SuppressWarnings("unchecked")
		List<StudentEO> users = query.getResultList();
		return users;

	}

	// 添加一个新的学生信息
	public boolean addNewStudent(StudentEO newStu) {

		// 先查找是否有重名的用户
		if (!findName(newStu.getName())) {

			// 需要编写密码转码
			em.persist(newStu);
			return true;// 用户名不重复
		} else {
			return false;// 用户名重复
		}
	}

	// 删除一个学生信息
	public void deleteStudent(String studentNum) {
		StudentEO aStu = findStudent(Integer.valueOf(studentNum));
		em.remove(aStu);
	}

	// 更新一个学生信息
	public void updateStudent(StudentEO Stu) {
		em.merge(Stu);
	}

	// 执行JPQL的查询语句来查找学生
	public List<StudentEO> executeQuery(String sql) {
		Query query = em.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<StudentEO> Students = query.getResultList();
		return Students;
	}

	public boolean findName_pwd(String name, String password) {
		Query query = em.createNamedQuery("findname_pwd")
				.setParameter("username", name)
				.setParameter("password", password);
		@SuppressWarnings("unchecked")
		List<StudentEO> users = query.getResultList();
		if (users.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	// 获得所有在数据库中书的数据
	public List<book> findAllbook() {
		@SuppressWarnings("unchecked")
		List<book> books = em.createNamedQuery("findAllbook").getResultList();
		return books;
	}

}
