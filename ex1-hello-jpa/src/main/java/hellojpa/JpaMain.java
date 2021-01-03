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

			Team team = new Team();
			team.setName("team1");
			entityManager.persist(team);

			Member member1 = new Member();
			member1.setUsername("test");
			member1.setTeam(team);
			entityManager.persist(member1);

			entityManager.flush();
			entityManager.clear();

			Member m = entityManager.find(Member.class, member1.getId());
			System.out.println("m = " + m.getTeam().getClass());

			System.out.println("==========");
			m.getTeam().getName(); // 프록시의 초기화
			System.out.println("==========");

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
