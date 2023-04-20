package guru.springframework.sdjpa.repository;

import guru.springframework.sdjpa.domain.primaryKey.AuthorPKUUID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorPKUUIDRepository extends JpaRepository<AuthorPKUUID, UUID> {
}
