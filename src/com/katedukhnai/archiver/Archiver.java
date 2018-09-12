package com.katedukhnai.archiver;

import com.katedukhnai.archiver.exception.WrongZipFileException;

import java.io.IOException;
import java.util.stream.Stream;

public class Archiver {
    public static void main(String[] args) {

        Operation operation = null;
        do {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            } catch (WrongZipFileException e) {
                e.printStackTrace();
                ConsoleHelper.writeMessage("Вы не выбрали архив или выбрали неверный файл.");
            } catch (Exception e) {
                e.printStackTrace();
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            }

        } while (operation != Operation.EXIT);
    }

    public static Operation askOperation() throws IOException {
        Stream.of(Operation.values())
                .forEach(operation -> ConsoleHelper.writeMessage(String.format("%s - %s",operation.ordinal(), operation.toString())));
        return Operation.values()[ConsoleHelper.readInt()];
    }
}