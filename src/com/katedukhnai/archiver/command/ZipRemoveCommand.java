package com.katedukhnai.archiver.command;

import com.katedukhnai.archiver.ConsoleHelper;
import com.katedukhnai.archiver.ZipFileManager;

public class ZipRemoveCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Удаление файла из архива.");

        ZipFileManager zipFileManager = getZipFileManager();

        ConsoleHelper.writeMessage("Введите название файла, который нужно удалить из архива:");
        String filename = ConsoleHelper.readString();
        zipFileManager.removeFile(filename);

        ConsoleHelper.writeMessage("Удаление завершено.");
    }
}