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

			member.getFavoriteFoods().add("치킨");
			member.getFavoriteFoods().add("족발");
			member.getFavoriteFoods().add("피자");

			member.getAddressHistory().add(new AddressEntity("old1", "street1", "1111"));
			member.getAddressHistory().add(new AddressEntity("old2", "street2", "2222"));

			entityManager.persist(member);

			entityManager.flush();
			entityManager.clear();

			System.out.println("----------------------START---------------");
			Member findMember = entityManager.find(Member.class, member.getId());

			//homeCity -> new City
			// findMember.getHomeAddress().setCity("newCity"); -> side effect 생기기 딱 좋음. 값타입은 immutable하다 
			Address old = findMember.getHomeAddress();
			findMember.setHomeAddress(new Address("newCity", old.getStreet(), old.getZipcode()));
			
			findMember.getFavoriteFoods().remove("치킨");
			findMember.getFavoriteFoods().add("한식");
			
			//equals 로 비교한다. 재정의 중요한 이유
			findMember.getAddressHistory().remove(new AddressEntity("old1", "street1", "1111"));
			findMember.getAddressHistory().add(new AddressEntity("newCity1", "street1", "1111"));
			
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
