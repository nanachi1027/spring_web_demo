package org.example.identity;

import org.example.model.user.User;
import org.example.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author: Mae
 * @Date: 2021/2/18 3:12 上午
 */
@Service
public class UserDetailService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();

    @Override
    public TokenUser loadUserByUsername(String username) throws UsernameNotFoundException, DisabledException {
        final User user = userRepo.findOneByUserId(username).orElseThrow(() -> new UsernameNotFoundException("User " + username + " does not exist"));
        TokenUser currentUser;
        if (user.isActive() == true) {
            currentUser = new TokenUser(user);
        } else {
            throw new DisabledException("User " + username + " is not activated (disabled user)");
        }
        detailsChecker.check(currentUser);
        return currentUser;
    }
}
