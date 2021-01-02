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

			Member member = new Member();
			member.setUsername("test");
			entityManager.persist(member);

			entityManager.flush();
			entityManager.clear();

//			Member findMember = entityManager.find(Member.class, member.getId());

			// select query 가 안나간다.
			Member findMember = entityManager.getReference(Member.class, member.getId());
			System.out.println("findMember.id = " + findMember.getId());

			System.out.println("before findMember = " + findMember.getClass());

			// getUsername 을 할 때 select 쿼리호출해서 값을 가져온다.
			System.out.println("findMember.username = " + findMember.getUsername());
			// 역속성컨텍스트에 값이 있기때문에 더이상 조회하지않음
			// System.out.println("findMember.username = " + findMember.getUsername());

			System.out.println("after findMember = " + findMember.getClass());

			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		entityMangerFactory.close();
	}
}
