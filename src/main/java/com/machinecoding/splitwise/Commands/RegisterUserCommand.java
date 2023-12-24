package com.machinecoding.splitwise.Commands;

import com.machinecoding.splitwise.Controllers.UserController;
import com.machinecoding.splitwise.DTO.RegisterUserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class RegisterUserCommand implements Command{

    private UserController userController;

    @Autowired
    public RegisterUserCommand(UserController userController) {
        this.userController = userController;
    }
    @Override
    public boolean matches(String input) {
        List<String> inputWords = Arrays.stream(input.split(" ")).toList();
        if(inputWords.size() == 4 || inputWords.get(0).equalsIgnoreCase(CommandKeywords.REGISTER_USER)){
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {
        List<String> inputWords = Arrays.stream(input.split(" ")).toList();

        String password = inputWords.get(1);
        String phoneNumber = inputWords.get(2);
        String username = inputWords.get(3);

        // call user controller and get our action done

        RegisterUserRequestDto registerUserRequestDto = new RegisterUserRequestDto();
        registerUserRequestDto.setUserName(username);
        registerUserRequestDto.setPhoneNumber(phoneNumber);
        registerUserRequestDto.setPassword(password);

        userController.registerUser(registerUserRequestDto);


    }
}
