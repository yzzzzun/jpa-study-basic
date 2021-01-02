package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Hibernate;

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
			System.out.println("refMember = " + refMember.getClass());
			System.out.println(
					"refMember isLoaded : " + entityMangerFactory.getPersistenceUnitUtil().isLoaded(refMember));

			// proxy 강제 초기화
			// JPA 표준은 강제 초기화가 없다. 강제 초기화 방법 -> refMember.getUsername();
			Hibernate.initialize(refMember);

			System.out.println(
					"refMember isLoaded : " + entityMangerFactory.getPersistenceUnitUtil().isLoaded(refMember));

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
