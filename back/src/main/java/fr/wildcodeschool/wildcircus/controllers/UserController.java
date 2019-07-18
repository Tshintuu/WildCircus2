package fr.wildcodeschool.wildcircus.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.wildcodeschool.wildcircus.repositories.UserDAO;
import fr.wildcodeschool.wildcircus.entities.User;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

    @Autowired
    private UserDAO dao;

    
    @GetMapping(value = "/users")
    public List<User> getAll() {
        return dao.findAll();
    }

    
    @GetMapping("/users/{id}")
    public User getById(@PathVariable("id") Long p_id) throws Exception {
        return dao.findById(p_id).get();
    }

    /**
     *
     * @param p_id L'identifiant de la l'utilisateur à MAJ
     * @param p_user L'objet de type User que le client nous envoie Cette méthode est
     *
     * protégée car la MAJ d'un utilisateur est un privilège du seul
     * SUPER_ADMIN
     */

    /**
     *
     * @param p_user L'objet de type user que le client nous envoie
     *
     * Cette méthode est protégée car la création d'un utilisateur
     * est un privilège du seul SUPER_ADMIN
     */
    @PostMapping("/users")
    public User create(@RequestBody User p_user) throws Exception {
        return dao.save(p_user);
    }


}