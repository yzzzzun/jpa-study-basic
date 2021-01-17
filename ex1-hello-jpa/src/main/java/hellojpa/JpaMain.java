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

			Member member = new Member();
			member.setUsername("member1");
			entityManager.persist(member);

			//flush가 자동으로 된다. -> query가 나가있어야 조회가 가능하기때문
			List<Member> resultList = entityManager.createNativeQuery("select member_id, city, street, zipcode, username from member", Member.class)
					.getResultList();

			//JPA와 전혀 연관없음, 미리 강제로 flush를 해줘야 데이터가 저장되어있어 쿼리가 가능
			//dbconn.executeQuery("select * from member");
			
			for (Member m : resultList) {
				System.out.println("member = " + member.getUsername());
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
