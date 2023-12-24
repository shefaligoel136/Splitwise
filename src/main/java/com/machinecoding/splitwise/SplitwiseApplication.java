package com.machinecoding.splitwise;

import com.machinecoding.splitwise.Commands.Command;
import com.machinecoding.splitwise.Commands.CommandRegistry;
import com.machinecoding.splitwise.Commands.RegisterUserCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner {

    private Scanner scanner;
    private CommandRegistry commandRegistry;

    @Autowired
    public SplitwiseApplication(CommandRegistry commandRegistry){
        scanner = new Scanner(System.in);
        this.commandRegistry = commandRegistry;
    }
    public static void main(String[] args) {
        SpringApplication.run(SplitwiseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        while(true){
            System.out.println("Tell me what to do?");
            String input = scanner.nextLine();

            commandRegistry.execute(input);
        }
    }
}
