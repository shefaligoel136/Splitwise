package com.machinecoding.splitwise.Commands;

public interface Command {
    boolean matches(String input);
    void execute(String input);

}
