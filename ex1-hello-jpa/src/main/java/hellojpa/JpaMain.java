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

			Movie movie = new Movie();
			movie.setActor("test1");
			movie.setDirector("test2");
			movie.setPrice(10000);
			movie.setName("바람과함께사라지다");

			entityManager.persist(movie);
			entityManager.flush();
			entityManager.clear();

			Movie findMovie = entityManager.find(Movie.class, movie.getId());
			System.out.println("findMovie = " + findMovie);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		entityMangerFactory.close();
	}
}
