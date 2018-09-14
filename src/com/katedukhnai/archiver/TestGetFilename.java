package com.katedukhnai.archiver;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestGetFilename {
    public static void main(String[] args) {
        System.out.println("Input path to file:");
        try {
            Path zipPath = Paths.get(IOHelper.readString());
            System.out.println("File name: " + zipPath.getFileName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
