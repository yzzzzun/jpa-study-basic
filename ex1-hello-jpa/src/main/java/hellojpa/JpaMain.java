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

			Member findMember = entityManager.find(Member.class, member1.getId());
			// find를 하면 뭘반환해야할까..? 조회하고 프록시가 반환된다. 트랜잭션 내에서 == true 를 보장해야하기 때문
			System.out.println("reference = " + findMember.getClass());

			// 영속성 컨텍스트 내에서 항상 true가 되어야함.
			// 중요한 포인트는 프록시던 아니던 문제없도록 개발하는게 중요하다.
			System.out.println("a==a : " + (refMember == findMember));

			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		entityMangerFactory.close();
	}

}
