package fr.wildcodeschool.wildcircus.repositories;


import fr.wildcodeschool.wildcircus.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

    public User findByUsername( String username );
}
