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

			Member refMember = entityManager.getReference(Member.class, member1.getId());
			// proxy 가 반환됨
			System.out.println("m1 = " + refMember.getClass());

			// 준영속 상태로 변경
//			entityManager.detach(refMember);
//			entityManager.close();
			entityManager.clear();

			// 영속성컨텍스트에서 준영속 상태가 되면 프록시 초기화가 불가.
			refMember.getUsername();

			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
		entityMangerFactory.close();
	}

}
