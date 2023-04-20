package guru.springframework.sdjpa.dao;

import guru.springframework.sdjpa.domain.Author;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class AuthorDaoImpl implements AuthorDao{
    private final DataSource  dataSource;
    private Connection connection =null;
    private Statement statement =null;
    private ResultSet resultSet =null;

    public AuthorDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Author getById(Long id) throws SQLException {

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
        }
        return null;
    }
    private void closeAll() throws SQLException {
        connection.close();
        statement.close();
        resultSet.close();

    }
}
