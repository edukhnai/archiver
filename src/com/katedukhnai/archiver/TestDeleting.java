package com.katedukhnai.archiver;


import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestDeleting {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("Введите полный путь к архиву:");
        String pathToArchive = in.nextLine();
        File zipFile = new File(pathToArchive);
        System.out.println("Введите, что удалять из архива (полный путь):");
        String filename = in.nextLine();
    }

    public static void deleteFile(String zipFilePath,String fileName) throws Exception{
        Map<String, String> zip_properties = new HashMap<>();
        zip_properties.put("create", "false");

        /* Specify the path to the ZIP File that you want to read as a File System */
        URI zip_disk = URI.create("jar:file:"+zipFilePath);

        /* Create ZIP file System */
        try (FileSystem zipfs = FileSystems.newFileSystem(zip_disk, zip_properties)) {
            /* Get the Path inside ZIP File to delete the ZIP Entry */
            Path pathInZipfile = zipfs.getPath(fileName);
            System.out.println("About to delete an entry from ZIP File" + pathInZipfile.toUri() );
            /* Execute Delete */
            Files.delete(pathInZipfile);
            System.out.println("File successfully deleted");
        }
    }

}