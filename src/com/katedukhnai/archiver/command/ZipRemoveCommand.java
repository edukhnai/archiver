package com.katedukhnai.archiver.command;

import com.katedukhnai.archiver.IOHelper;
import com.katedukhnai.archiver.ZipFileManager;

public class ZipRemoveCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        IOHelper.writeMessage("Удаление файла из архива.");
        ZipFileManager zipFileManager = getZipFileManager();

        IOHelper.writeMessage("Введите название файла, который нужно удалить из архива:");
        String filename = IOHelper.readString();
        zipFileManager.removeFile(filename);

        IOHelper.writeMessage("Удаление завершено.");
    }
}