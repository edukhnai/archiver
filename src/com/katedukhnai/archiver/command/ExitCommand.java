package com.katedukhnai.archiver.command;

import com.katedukhnai.archiver.ConsoleHelper;

public class ExitCommand implements Command {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Goodbye!");
    }
}
