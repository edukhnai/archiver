package com.katedukhnai.archiver;

import java.io.*;
import java.util.List;

public class IOHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static void writeMessage(List<String> messages, FileOutputStream fos) {
        try (PrintWriter p = new PrintWriter(fos)) {
            for (String s : messages)
                p.println(s);
        }
    }

    public static String readString() throws IOException {
        return bis.readLine();
    }

    public static int readInt() {
        int i = -1;
        try {
            i = Integer.parseInt(readString().trim());
        } catch (IOException e) {
            IOHelper.writeMessage("Ошибка ввода");
        }
        return i;
    }
}
