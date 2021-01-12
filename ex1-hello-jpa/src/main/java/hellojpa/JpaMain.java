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
			Address homeAddress = new Address("city", "street", "100");

			Member member = new Member();
			member.setUsername("member1");
			member.setHomeAddress(homeAddress);

			entityManager.persist(member);

			// 통으로 수정해줘야 한다.
			Address newAddress = new Address("new city", homeAddress.getStreet(), homeAddress.getZipcode());
			member.setHomeAddress(newAddress);

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
