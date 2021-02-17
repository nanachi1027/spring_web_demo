package org.example.identity;

import org.example.model.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;

/**
 * @Author: Mae
 * @Date: 2021/2/18 3:02 上午
 */
public class TokenUser extends org.springframework.security.core.userdetails.User {
    private User user;


    public TokenUser(User user) {
        super(user.getUserId(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public String getRole() {
        return user.getRole().toString();
    }
}
