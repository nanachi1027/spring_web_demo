package org.example.api.user;

import com.google.common.base.Strings;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.model.response.OperationResponse;
import org.example.model.user.User;
import org.example.model.user.UserResponse;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Mae
 * @Date: 2021/2/18 4:24 上午
 */
@RestController
@Api(tags = {"Authentication"})
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value =" Gets current user information", response = UserResponse.class)
    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = {"application/json"})
    public UserResponse getUserInfo(@RequestParam(value = "name", required = false) String userIdParam, HttpServletRequest req) {
        String loggedInUserId = userService.getLoggedUserId();
        User user;
        boolean providedUserDetails = false;

        if (Strings.isNullOrEmpty(userIdParam)) {
            providedUserDetails = true;
            user = userService.getLoggedInUser();
        } else if (loggedInUserId.equals(userIdParam)) {
            providedUserDetails = true;
            user = userService.getLoggedInUser();
        } else {
            providedUserDetails = true;
            user = userService.getUserInfoByUserId(userIdParam);
        }
        UserResponse resp = new UserResponse();
        if (providedUserDetails) {
            resp.setOperationStatus(OperationResponse.ResponseStatusEnum.SUCCESS);
        } else {
            resp.setOperationStatus(OperationResponse.ResponseStatusEnum.NO_ACCESS);
        }
        resp.setData(user);
        return resp;
    }
}
