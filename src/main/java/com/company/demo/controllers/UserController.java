package com.company.demo.controllers;

import com.company.demo.models.User;
import com.company.demo.models.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Controller for user creating and user status update
 *
 */
@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    /**
     * Returns picture-upload.html
     *
     * @return upload page
     */
    @RequestMapping(value = "/create-user", method = RequestMethod.GET)
    public String returnCreateUserPage() {
        return "create-user";
    }

    /**
     * Create a new user and save it in the database.
     *
     * @param email     User email
     * @param name      User name
     * @param phone     User phone
     * @param address   User address
     * @param pictureId User PictureID
     * @return A string describing if the user is succesfully created or not.
     */
    @RequestMapping("/create")
    @ResponseBody
    public User create(String email, String name, String phone, String address, long pictureId) {
        User user = new User(email, name, phone, address, pictureId, false, new Date());
        userDao.save(user);
        return user;
    }

    /**
     * Return the user having the passed id.
     *
     * @param id The ID to search in the database.
     * @return The user id or a message error if the user is not found.
     */
    @RequestMapping("/user/{id}")
    @ResponseBody
    public User getById(@PathVariable("id") long id) {
        return userDao.findById(id);
    }

}
