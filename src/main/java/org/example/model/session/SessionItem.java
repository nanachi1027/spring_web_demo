package org.example.model.session;

import lombok.Data;

import java.util.List;

/**
 * @Author: Mae
 * @Date: 2021/2/18 2:17 上午
 */
@Data
public class SessionItem {
    private String token;
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private List<String> roles;
}
