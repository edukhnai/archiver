package com.katedukhnai.archiver.command;

import com.katedukhnai.archiver.IOHelper;
import com.katedukhnai.archiver.ZipFileManager;
import com.katedukhnai.archiver.exception.PathIsNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipAddCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            IOHelper.writeMessage("Добавление нового файла в архив.");
            ZipFileManager zipFileManager = getZipFileManager();

            IOHelper.writeMessage("Введите полный путь к файлу, который нужно добавить:");
            Path sourcePath = Paths.get(IOHelper.readString());
            zipFileManager.addFile(sourcePath);

            IOHelper.writeMessage("Файл " + sourcePath.getFileName() + " был добавлен в архив.");

        } catch (PathIsNotFoundException e) {
            IOHelper.writeMessage("Файл не был найден.");
        }
    }
}
