package guru.springframework.sdjpa.dao;

import guru.springframework.sdjpa.domain.Author;

import java.sql.SQLException;
import java.util.Set;

public interface AuthorDao {
    Author getById(Long id) throws SQLException;
    Set<Author> findAuthorByLastName(String lastName) throws SQLException;
    Author save(Author author) throws SQLException;
    Set<Author> findAll() throws SQLException;
    void deleteById(Long id) throws SQLException;
    void deleteAuthor(Author author) throws SQLException;
}
