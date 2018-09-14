package com.katedukhnai.archiver.command;

import com.katedukhnai.archiver.IOHelper;
import com.katedukhnai.archiver.ZipFileManager;
import com.katedukhnai.archiver.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipExtractCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            IOHelper.writeMessage("Распаковка архива.");

            ZipFileManager zipFileManager = getZipFileManager();

            IOHelper.writeMessage("Введите путь, куда распаковывать:");
            Path destinationPath = Paths.get(IOHelper.readString());
            zipFileManager.extractAll(destinationPath);

            IOHelper.writeMessage("Архив был распакован.");

        } catch (PathIsNotFoundException e) {
            IOHelper.writeMessage("Неверный путь для распаковки.");
        }
    }
}
