package guru.springframework.sdjpa.repository;

import guru.springframework.sdjpa.domain.primaryKey.BookPKUUIDRFC4122;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookPKUUIDRFC4122Repository extends JpaRepository<BookPKUUIDRFC4122, UUID> {
}
