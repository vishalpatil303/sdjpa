package guru.springframework.sdjpa;

import guru.springframework.sdjpa.repository.BookRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SdjpaApplicationTests {

	@Autowired
	BookRepository bookRepository;
	@Test
	void contextLoads() {
	}
	@Test
	void testBookRepository(){
		Long count = bookRepository.count();
		Assertions.assertThat(count).isEqualTo(2);
	}

}
