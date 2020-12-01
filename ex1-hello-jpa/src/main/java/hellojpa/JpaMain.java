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
			team.setName("TeamA");
			entityManager.persist(team);
			
			Member member = new Member();
			member.setUsername("member1");
			entityManager.persist(member);
			
			team.addMember(member);
			
			//flush하면 DB에서 불러오기때문에 상관없지
			//1차 캐시에서 가져오는 경우 문제될 수 있
			//양방향 set할때 양쪽에 set하는게 맞다
			
			//영속성 컨텍스 쿼리 호출해서 DB와 sync를 맞춤 
//			entityManager.flush();
//			entityManager.clear();
			
			Team findTeam = entityManager.find(Team.class, team.getId());
			List<Member> members = findTeam.getMembers();
			System.out.println("=================");
			for (Member m : members) {
				System.out.println("m = " + m.getUsername());
			}
			System.out.println("=================");
			
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		entityMangerFactory.close();
	}
}
