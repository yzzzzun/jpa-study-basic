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

			Member member2 = new Member();
			member2.setUsername("test");
			entityManager.persist(member2);

			entityManager.flush();
			entityManager.clear();

			Member m1 = entityManager.find(Member.class, member1.getId());
			Member m2 = entityManager.getReference(Member.class, member2.getId());

			logic(m1, m2);

			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		entityMangerFactory.close();
	}

	// 실무에서 타입비교가 이뤄진다면 메서드로 이뤄질것, 절대 타입비교 ==으로 하면 안됨
	private static void logic(Member m1, Member m2) {
		System.out.println("m1 == m2 : " + (m1 instanceof Member));
		System.out.println("m1 == m2 : " + (m2 instanceof Member));
	}
}
