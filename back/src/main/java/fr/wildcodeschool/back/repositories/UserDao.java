package fr.wildcodeschool.back.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import fr.wildcodeschool.back.entities.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    private final static String DB_URL = "jdbc:mysql://localhost:3306/wildcircus2?serverTimezone=GMT";
    private final static String DB_USER = "admin";
    private final static String DB_PASSWORD = "zpPDR9AA@";

    public static int insert(

    String username,
    String password
    ) {
        try(
            Connection connection = DriverManager.getConnection(
                DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO wizard (username, password) VALUES (?, ?)",
                Statement.RETURN_GENERATED_KEYS
            );
        ) {
            statement.setString(1 ,username);
            statement.setString(2, password);

            if(statement.executeUpdate() != 1) {
                throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "failed to insert data"
                );
            }

            try(
                ResultSet generatedKeys = statement.getGeneratedKeys();
            ) {
                if(generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
                else {
                    throw new ResponseStatusException(
                        HttpStatus.INTERNAL_SERVER_ERROR, "failed to get inserted id"
                    );
                }
            }
        }
        catch (SQLException e) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR, "", e
            );
        }
    }
    
}