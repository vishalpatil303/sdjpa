package guru.springframework.sdjpa.dao;

import guru.springframework.sdjpa.domain.Author;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

@Component
public class AuthorDaoImpl implements AuthorDao{
    private final DataSource  dataSource;
    private Connection connection =null;
    private Statement statement =null;
    private PreparedStatement preparedStatement =null;
    private ResultSet resultSet =null;

    public AuthorDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Author getById(Long id) throws SQLException {

/*       //Statement
            try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select * from Author where id =" + id);
            if(resultSet.next()){
                Author a = new Author();
                a.setId(resultSet.getLong("id"));
                a.setFirstName(resultSet.getString("first_name"));
                a.setLastName(resultSet.getString("last_name"));
                return a;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            closeAll();
        }*/

        //Use PreparedStatement
        try{
            connection =dataSource.getConnection();
            preparedStatement=connection.prepareStatement("select * from author where id = ?");
            preparedStatement.setLong(1,id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                Author a = new Author();
                a.setId(resultSet.getLong("id"));
                a.setFirstName(resultSet.getString("first_name"));
                a.setLastName(resultSet.getString("last_name"));
                return a;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            closeAll();
        }
        return null;
    }

    @Override
    public Set<Author> findAuthorByLastName(String lastName) throws SQLException {
        Set<Author> authors = new HashSet<>();
        try{
            connection = dataSource.getConnection();
            preparedStatement =connection.prepareStatement("Select * from author where last_name = ?");
            preparedStatement.setString(1,lastName);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                Author a = new Author();
                a.setId(resultSet.getLong("id"));
                a.setFirstName(resultSet.getString("first_name"));
                a.setLastName(resultSet.getString("last_name"));
                authors.add(a);
            }
            return authors;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            closeAll();
        }
        return null;
    }

    @Override
    public Author save(Author author) throws SQLException {
       if(author.getId()== null) {
           try {
               connection = dataSource.getConnection();
               preparedStatement = connection.prepareStatement("insert into author (first_name, last_name) values (?,?)");
               preparedStatement.setString(1, author.getFirstName());
               preparedStatement.setString(2, author.getLastName());
               preparedStatement.execute();

               return null;

                } catch (SQLException e) {
                    e.printStackTrace();
                }finally {
                    closeAll();
                }
            }else{
               try{
                   Author foundAuthor = getById(author.getId());
                   connection = dataSource.getConnection();
                   if(author.getFirstName()==null){
                       author.setFirstName(foundAuthor.getFirstName());
                   }
                   if(author.getLastName()==null){
                       author.setLastName(foundAuthor.getLastName());
                   }
                   preparedStatement = connection.prepareStatement("update author set first_name = ?, last_name = ? where id = ?");
                   preparedStatement.setString(1, author.getFirstName());
                   preparedStatement.setString(2, author.getLastName());
                   preparedStatement.setLong(3,author.getId());
                   preparedStatement.execute();
                   return null;

               } catch (SQLException e) {
                   e.printStackTrace();
               }finally {
                   closeAll();
               }
           }

        return null;
    }

    @Override
    public Set<Author> findAll() throws SQLException {
        Set<Author> authors = new HashSet<>();
        try{
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select * from author");
            while (resultSet.next()){
                Author a = new Author();
                a.setId(resultSet.getLong("id"));
                a.setFirstName(resultSet.getString("first_name"));
                a.setLastName(resultSet.getString("last_name"));
                authors.add(a);
            }
            return authors;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            closeAll();
        }
        return null;
    }

    @Override
    public void deleteById(Long id) throws SQLException {
        if(getById(id) != null) {
            try {
                connection = dataSource.getConnection();
                preparedStatement = connection.prepareStatement("DELETE from author where id = ?");
                preparedStatement.setLong(1,id);
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeAll();
            }
        }else {
            throw new NoSuchElementException("Could not found User with ID");
        }
    }

    @Override
    public void deleteAuthor(Author author) throws SQLException {
        deleteById(author.getId());
    }

    private void closeAll() throws SQLException {
        if(connection != null){
        connection.close();
        }
        if(statement != null) {
            statement.close();
        }
        if(resultSet != null) {
            resultSet.close();
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }

    }
}
