package fr.wildcodeschool.wildcircus.repositories;

import fr.wildcodeschool.wildcircus.entities.UserMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMessageRepository extends JpaRepository<UserMessage, Long> {

    List<UserMessage> findByFirstnameAndLastnameAndSubjectAndIdAndMessage(String firstname, String lastname, String subject, Long id, String message);

}
