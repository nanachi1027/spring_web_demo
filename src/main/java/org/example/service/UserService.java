package org.example.service;

import org.example.model.user.User;
import org.example.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @Author: Mae
 * @Date: 2021/2/18 4:23 上午
 */
@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public String getLoggedUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return "nosession";
        }
        return auth.getName();
    }

    public User getLoggedInUser() {
        String loggedInUserId = this.getLoggedUserId();
        User user = this.getUserInfoByUserId(loggedInUserId);
        return user;
    }

    public User getUserInfoByUserId(String loggedInUserId) {
        User user = this.userRepo.findOneByUserId(loggedInUserId).orElseGet(() -> new User());
        return user;
    }

    public boolean insertOrSaveUser(User user) {
        this.userRepo.save(user);
        return true;
    }

    public boolean addNewUser(User user) {
        User newUser = this.getUserInfoByUserId(user.getUserId());
        if (newUser.getUserId().equals("new")) {
            return this.insertOrSaveUser(user);
        } else {
            return false;
        }
    }
}
