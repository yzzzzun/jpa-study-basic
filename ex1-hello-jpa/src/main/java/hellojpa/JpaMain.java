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

			// copy 해서 사용
			Address copyAddress = new Address(homeAddress.getCity(), homeAddress.getStreet(), homeAddress.getZipcode());

			Member member1 = new Member();
			member1.setUsername("member1");
			member1.setHomeAddress(homeAddress);

			Member member2 = new Member();
			member2.setUsername("member2");
			member2.setHomeAddress(copyAddress);

			entityManager.persist(member1);
			entityManager.persist(member2);

			// 값타입을 불변객체로 만들어버리면 컴파일 레벨에서 side effect 차단 가능
			// member1.getHomeAddress().setCity("new City");

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
