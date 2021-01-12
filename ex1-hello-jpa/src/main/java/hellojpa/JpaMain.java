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

			Member member1 = new Member();
			member1.setUsername("member1");
			member1.setHomeAddress(homeAddress);

			Member member2 = new Member();
			member2.setUsername("member2");
			member2.setHomeAddress(homeAddress);

			// member1의 주소에서 city값을 변경 -> 하지만 member2도 변경됨
			// member1,member2의 값을 모두 공유하려고했다? -> address가 값타입이아닌 엔티티로 설계해야함
			member1.getHomeAddress().setCity("new City");

			entityManager.persist(member1);
			entityManager.persist(member2);

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
