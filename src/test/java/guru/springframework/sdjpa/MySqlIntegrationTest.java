/*
package guru.springframework.sdjpa;

import guru.springframework.sdjpa.repository.BookRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

//@ActiveProfiles("local")
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@ComponentScan(basePackages = {"guru.springframework.sdjpa.boostrap"})

public class MySqlIntegrationTest
{
    @Autowired
    BookRepository bookRepository;
    @Test
    void testMySql(){
        Long count =bookRepository.count();
        Assertions.assertThat(count).isEqualTo(2);
    }
}
*/
