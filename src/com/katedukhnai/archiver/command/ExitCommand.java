package com.katedukhnai.archiver.command;

import com.katedukhnai.archiver.IOHelper;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        IOHelper.writeMessage("До встречи!");
    }
}
