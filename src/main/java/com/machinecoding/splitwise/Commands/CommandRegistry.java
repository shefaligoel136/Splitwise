package com.machinecoding.splitwise.Commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandRegistry {
    private List<Command> commandList;

    @Autowired
    public CommandRegistry(RegisterUserCommand registerUserCommand){
        commandList = new ArrayList<>();
        commandList.add(registerUserCommand);
        //        commandList.add(new UpdateUserCommand());
        //        commandList.add(new settleUserCommand());
    }

    public void execute(String input){
        for(Command command: commandList){
            if(command.matches(input)){
                command.execute(input);
                break;
            }
        }
    }
}
