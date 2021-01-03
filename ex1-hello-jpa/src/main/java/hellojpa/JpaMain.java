package hellojpa;

import java.util.List;

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
			team.setName("teamA");
			entityManager.persist(team);

			Team teamB = new Team();
			team.setName("teamB");
			entityManager.persist(teamB);

			Member member1 = new Member();
			member1.setUsername("test");
			member1.setTeam(team);
			entityManager.persist(member1);

			Member member2 = new Member();
			member2.setUsername("test");
			member2.setTeam(teamB);
			entityManager.persist(member2);

			entityManager.flush();
			entityManager.clear();

			// eager 로 설정되어있지만 쿼리가 두번나간다
			// JPQL 은 쿼리를 우선 변경, Member를 가지고와보니 즉시로딩이네? -> team 쿼리수행
			// select * from Member
			// select * from Team where team_id = xxx
			// N+1 문제발생
			List<Member> resultList = entityManager
					.createQuery("select m from Member m join fetch m.team", Member.class).getResultList(); //$NON-NLS-1$

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
