/**
 * FileName : JpaMain.java
 * Created  : 2021. 1. 17.
 * Author   : youngjun.jin
 * Summary  :
 * Copyright (C) 2021 yzzzzun. All rights reserved.
 *
 * 이 문서의 모든 저작권 및 지적 재산권은 yzzzzun에게 있습니다.
 * 이 문서의 어떠한 부분도 허가 없이 복제 또는 수정 하거나, 전송할 수 없습니다.
 */
package jpql;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * @author youngjun.jin
 */
public class JpaMain {

	/**
	 * @author youngjun.jin
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory entityMangerFactory = Persistence.createEntityManagerFactory("hello");
		EntityManager entityManager = entityMangerFactory.createEntityManager();

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		try {

			Team teamA = new Team();
			teamA.setName("teamA");
			entityManager.persist(teamA);

			Team teamB = new Team();
			teamB.setName("teamB");
			entityManager.persist(teamB);

			Member memberA = new Member();
			memberA.setUsername("회원1");
			memberA.changeTeam(teamA);
			entityManager.persist(memberA);
			Member memberB = new Member();
			memberB.setUsername("회원2");
			memberB.changeTeam(teamA);
			entityManager.persist(memberB);
			Member memberC = new Member();
			memberC.setUsername("회원3");
			memberC.changeTeam(teamB);
			entityManager.persist(memberC);

			entityManager.flush();
			entityManager.clear();

			String query = "select m from Member m";

			List<Member> result = entityManager
				.createQuery(query, Member.class)
				.getResultList();
			for (Member member : result) {
				System.out.println("member = " + member.getUsername() + ", " + member.getTeam().getName());
				//회원1, teamA(SQL)
				//회원2, teamA(1차 캐시)
				//회원3, teamB(SQL)
				//회원 100명 => N + 1
				// 회원을 가져오기위한 쿼리.. 100번 team을 조회

				//페치조인으로 풀어라
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
