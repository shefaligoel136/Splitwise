package com.machinecoding.splitwise.Controllers;

import com.machinecoding.splitwise.DTO.RegisterUserRequestDto;
import com.machinecoding.splitwise.DTO.RegisterUserResponseDto;
import com.machinecoding.splitwise.Exceptions.UserAlreadyExistsException;
import com.machinecoding.splitwise.Models.User;
import com.machinecoding.splitwise.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public RegisterUserResponseDto registerUser(RegisterUserRequestDto request) {
        User user;
        RegisterUserResponseDto response = new RegisterUserResponseDto();

        try {
            user = userService.registerUser(
                    request.getUserName(),
                    request.getPhoneNumber(),
                    request.getPassword()
            );
            response.setUserId(user.getId());
            response.setStatus("SUCCESS");
        } catch (UserAlreadyExistsException userAlreadyExistsException) {
            response.setStatus("FAILURE");
            response.setMessage(userAlreadyExistsException.getMessage());
        }

        System.out.println("response" + " " + response);

        return response;
    }

}
