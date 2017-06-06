package javaee.jsf.ejb;

import java.util.List;

import javaee.jsf.StuEntities.StudentEO;
import javaee.jsf.StuEntities.book;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

//������һ�� ��״̬�ỰBean��ʵ��ʵ��ĸ��ֲ���
@Stateless
public class DBop {
	// @PersistenceContext�����Ա�ע�ķ�ʽע��һ��ʵ������������еġ�jsf_example������persistence.xml�ж���ĳ־û���Ԫ������
	@PersistenceContext(unitName = "jsf_example")
	private EntityManager em;

	public DBop() {

	}

	// ������ʵ��BeanStudentEO�ж���Ĳ�ѯ"findAllStudent"��ȡ�����е�ѧ������
	public List<StudentEO> getAllStudent() {
		@SuppressWarnings("unchecked")
		List<StudentEO> Students = em.createNamedQuery("findAlluser")
				.getResultList();
		return Students;
	}

	// �õ�����idֵ
	public int getid() {
		List<StudentEO> list = getAllStudent();
		if (list.size() == 0) {
			return 0;
		} else {
			return list.get(list.size() - 1).getId();
		}

	}

	// ������ʵ��BeanStudentEO�ж���Ĳ�ѯ"findStudentByID"����ѧ�Ų���һ��ѧ��
	public StudentEO findStudent(Integer pStuID) {
		@SuppressWarnings("unchecked")
		List<StudentEO> tStuList = em.createNamedQuery("finduserByID")
				.setParameter("studentNum", pStuID).getResultList();
		return tStuList.get(0);
	}

	// �����й��û����ķ���
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

	// ���һ���µ�ѧ����Ϣ
	public boolean addNewStudent(StudentEO newStu) {

		// �Ȳ����Ƿ����������û�
		if (!findName(newStu.getName())) {

			// ��Ҫ��д����ת��
			em.persist(newStu);
			return true;// �û������ظ�
		} else {
			return false;// �û����ظ�
		}
	}

	// ɾ��һ��ѧ����Ϣ
	public void deleteStudent(String studentNum) {
		StudentEO aStu = findStudent(Integer.valueOf(studentNum));
		em.remove(aStu);
	}

	// ����һ��ѧ����Ϣ
	public void updateStudent(StudentEO Stu) {
		em.merge(Stu);
	}

	// ִ��JPQL�Ĳ�ѯ���������ѧ��
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

	// ������������ݿ����������
	public List<book> findAllbook() {
		@SuppressWarnings("unchecked")
		List<book> books = em.createNamedQuery("findAllbook").getResultList();
		return books;
	}

}
