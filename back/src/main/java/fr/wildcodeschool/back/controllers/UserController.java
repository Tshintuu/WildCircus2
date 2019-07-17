package fr.wildcodeschool.back.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import fr.wildcodeschool.back.entities.User;
import fr.wildcodeschool.back.repositories.UserDao;

@Controller
@ResponseBody
public class UserController {
    

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User store(

    @RequestParam String username,
    @RequestParam String password
    ) {
        int idGeneratedByInsertion = UserDao.insert(
            username,
            password
        );
        return UserDao.selectById(idGeneratedByInsertion);
    }

}