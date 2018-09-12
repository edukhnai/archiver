package com.katedukhnai.archiver.command;

import com.katedukhnai.archiver.ConsoleHelper;
import com.katedukhnai.archiver.ZipFileManager;
import com.katedukhnai.archiver.exception.PathIsNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipAddCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Добавление нового файла в архив.");

            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("Введите полный путь к файлу, который нужно добавить:");
            Path sourcePath = Paths.get(ConsoleHelper.readString());

            zipFileManager.addFile(sourcePath);

            ConsoleHelper.writeMessage("Файл " + sourcePath.getFileName() + " был добавлен в архив.");

        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("Файл не был найден.");
        }
    }
}
