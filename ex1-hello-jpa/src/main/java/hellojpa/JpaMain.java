package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

	public static void main(String[] args) {
		EntityManagerFactory entityMangerFactory = Persistence.createEntityManagerFactory("hello");
		EntityManager entityManager = entityMangerFactory.createEntityManager();

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		try {

			Member member1 = new Member();
			member1.setUsername("test");
			entityManager.persist(member1);

			entityManager.flush();
			entityManager.clear();

			Member m1 = entityManager.find(Member.class, member1.getId());
			System.out.println("m1 = " + m1.getClass());

			// 이미 영속성컨텍스트에 member가 올라와있기 때문에 프록시를 반환해봐야 얻는 이점도 없기 때문
			Member reference = entityManager.getReference(Member.class, member1.getId());
			System.out.println("m1 = " + reference.getClass());

			// 영속성 컨텍스트 내에서 항상 true가 되어야함
			System.out.println("a==a : " + (m1 == reference));

			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		entityMangerFactory.close();
	}

}
