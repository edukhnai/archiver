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
                IOHelper.writeMessage("Вы не выбрали архив или выбрали неверный файл.");
                System.out.println("---------------------------------------------------");
                e.printStackTrace();
                System.out.println("---------------------------------------------------");
            } catch (Exception e) {
                IOHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
                System.out.println("---------------------------------------------------");
                e.printStackTrace();
                System.out.println("---------------------------------------------------");
            }

        } while (operation != Operation.EXIT);
    }

    public static Operation askOperation() {
        Stream.of(Operation.values())
                .forEach(operation -> IOHelper.writeMessage(String.format("%s - %s",operation.ordinal(), operation.toString())));
        return Operation.values()[IOHelper.readInt()];
    }
}