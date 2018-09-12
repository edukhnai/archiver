package com.katedukhnai.archiver;

public enum Operation {

    CREATE("упаковать файлы в архив"),
    ADD("добавить файл в архив"),
    REMOVE("удалить файл из архива"),
    EXTRACT("распаковать архив"),
    CONTENT("просмотреть содержимое архива"),
    EXIT("выход");

    private String comment;

    Operation(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return comment;
    }
}