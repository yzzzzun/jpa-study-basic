package hellojpa;

import java.util.List;
import java.util.Set;

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

			member.getAddressHistory().add(new Address("old1", "street1", "1111"));
			member.getAddressHistory().add(new Address("old2", "street2", "2222"));

			entityManager.persist(member);

			entityManager.flush();
			entityManager.clear();

			System.out.println("----------------------START---------------");
			Member findMember = entityManager.find(Member.class, member.getId());

			//LAZY Loading 확인 
			List<Address> addressHistory = findMember.getAddressHistory();
			for (Address address : addressHistory) {

				System.out.println("address = " + address.getCity());
			}

			Set<String> favoriteFoods = findMember.getFavoriteFoods();
			for (String food : favoriteFoods) {

				System.out.println("favorite food = " + food);
			}

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
