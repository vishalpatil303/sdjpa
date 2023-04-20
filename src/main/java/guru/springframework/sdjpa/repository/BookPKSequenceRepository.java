package guru.springframework.sdjpa.repository;

import guru.springframework.sdjpa.domain.primaryKey.BookPKSequence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookPKSequenceRepository extends JpaRepository<BookPKSequence,Long> {
}
