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
			member.setTeam(team);
			entityManager.persist(member);
			
			//영속성 컨텍스 쿼리 호출해서 DB와 sync를 맞춤 
			entityManager.flush();
			entityManager.clear();
			
			Member findMember = entityManager.find(Member.class, member.getId());
			List<Member> members = findMember.getTeam().getMembers();
			for (Member m : members) {
				System.out.println("m = " + m.getUsername());
			}
			
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		entityMangerFactory.close();
	}
}
