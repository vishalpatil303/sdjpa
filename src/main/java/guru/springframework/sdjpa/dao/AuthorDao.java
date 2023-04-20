package guru.springframework.sdjpa.dao;

import guru.springframework.sdjpa.domain.Author;

import java.sql.SQLException;

public interface AuthorDao {
    Author getById(Long id) throws SQLException;
}
