package guru.springframework.sdjpa.repository;

import guru.springframework.sdjpa.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {


}
