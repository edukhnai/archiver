package com.katedukhnai.archiver.command;

import com.katedukhnai.archiver.IOHelper;
import com.katedukhnai.archiver.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class ZipCommand implements Command {

    public ZipFileManager getZipFileManager() throws Exception{
        IOHelper.writeMessage("Введите полный путь к архиву (без расширения):");
        Path zipPath = Paths.get(IOHelper.readString().concat(".zip"));

        return new ZipFileManager(zipPath);
    }
}