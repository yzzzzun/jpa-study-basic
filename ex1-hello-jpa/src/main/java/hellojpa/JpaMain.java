package hellojpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JpaMain {

	public static void main(String[] args) {
		EntityManagerFactory entityMangerFactory = Persistence.createEntityManagerFactory("hello");
		EntityManager entityManager = entityMangerFactory.createEntityManager();

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		try {

			//entity를 대상으로 쿼리함
			//단순한 스트링이다.-> 동적쿼리를 만들기 쉽지않다.
			String query = "select m from Member m where m.username like '%kim%'";
			List<Member> resultList = entityManager.createQuery(query, Member.class)
					.getResultList();

			for (Member member : resultList) {
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
