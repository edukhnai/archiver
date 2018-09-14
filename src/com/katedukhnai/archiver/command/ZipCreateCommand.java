package com.katedukhnai.archiver.command;

import com.katedukhnai.archiver.IOHelper;
import com.katedukhnai.archiver.ZipFileManager;
import com.katedukhnai.archiver.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipCreateCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            IOHelper.writeMessage("Создание архива.");
            ZipFileManager zipFileManager = getZipFileManager();

            IOHelper.writeMessage("Введите полное имя файла или директории для архивации:");
            Path sourcePath = Paths.get(IOHelper.readString());

            zipFileManager.createZip(sourcePath);
            IOHelper.writeMessage("Архив создан.");
        } catch (PathIsNotFoundException e) {
            IOHelper.writeMessage("Вы неверно указали имя файла или директории.");
        }
    }
}
