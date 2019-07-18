package fr.wildcodeschool.wildcircus.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class UserMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String firstname;
    private String lastname;
    private String subject;
    private String message;
    private String email;
    private String phone;

    public UserMessage(){ }

    public UserMessage(String firstname, String lastname, String subject, String message, String email, String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.subject = subject;
        this.message = message;
        this.email = email;
        this.phone = phone;
    }

    public UserMessage(Long id,String firstname, String lastname, String subject, String message, String email, String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.subject = subject;
        this.message = message;
        this.id = id;
        this.email = email;
        this.phone = phone;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
