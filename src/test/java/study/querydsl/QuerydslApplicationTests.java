package study.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class QuerydslApplicationTests {

	@Autowired
	EntityManager em;

	@Test
	void contextLoads() {
		Verification verification = new Verification();
		em.persist(verification);

		JPAQueryFactory query = new JPAQueryFactory(em);

		QVerification qVerification = new QVerification("q");

		Verification result = query
				.selectFrom(qVerification)
				.fetchOne();

		assertThat(result).isEqualTo(verification);
		assertThat(result.getId()).isEqualTo(verification.getId());
	}

}
