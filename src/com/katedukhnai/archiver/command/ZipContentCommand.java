package com.katedukhnai.archiver.command;

import com.katedukhnai.archiver.FileProperties;
import com.katedukhnai.archiver.IOHelper;
import com.katedukhnai.archiver.ZipFileManager;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.stream.Collectors;

public class ZipContentCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        IOHelper.writeMessage("Просмотр содержимого архива.");
        ZipFileManager zipFileManager = getZipFileManager();

        IOHelper.writeMessage("Выберите, куда вывести информацию:\nВ лог-файл - 1 \nВ консоль - 2");
        int num = 0;
        do {
            num = IOHelper.readInt();
        } while (num != 1 && num != 2);

        List<FileProperties> files = zipFileManager.getFilesList();

        if (num == 2) {
            IOHelper.writeMessage("Содержимое архива:");
            for (FileProperties file : files) {
                IOHelper.writeMessage(file.toString());
            }
        } else {
            File file = new File("archive_info_" + zipFileManager.getZipFile().getFileName().toString().replaceFirst(".zip", ""));
            List<String> infos = files.stream().map(FileProperties::toString).collect(Collectors.toList());
            try (FileOutputStream fos = new FileOutputStream(file)) {
                    IOHelper.writeMessage(infos, fos);
            }
        }
        IOHelper.writeMessage("Содержимое архива прочитано.");
    }
}
