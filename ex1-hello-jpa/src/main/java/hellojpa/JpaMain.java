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
			//객체지향스럽지 않은 형태, 협력관계 만들 수 없다. -> 데이터 중심의 모델링 
			Team team = new Team();
			team.setName("TeamA");
			entityManager.persist(team);
			//단점1 - 외래키 식별자를 직접 다루는 형태 
			Member member = new Member();
			member.setUsername("member1");
			member.setTeamId(team.getId());
			entityManager.persist(member);
			
			// 객체는 참조를 사용해서 연관관계를 가져야 객체지향적..
			Member findMember = entityManager.find(Member.class, member.getId());
			Long findTeamId = findMember.getTeamId();
			Team findTeam = entityManager.find(Team.class, findTeamId);
			
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		entityMangerFactory.close();
	}
}
