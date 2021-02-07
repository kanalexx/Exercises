package com.kanaa;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Ресурсный файл
 *
 * @author Alexander Kanunnikov
 */

public class Resources {

    private static final String FULL_PATH_FMT = System.getProperty("user.dir") + "\\resources\\%s";

    /**
     * Добавляет к {@code}fileName путь до каталога с ресурсными файлами
     * @return полный путь до ресурсного файла
     */
    public static String path(String fileName) {
        return String.format(FULL_PATH_FMT, fileName);
    }

    /**
     * Создает список с полными путями для ресурсных файлов
     */
    public static List<String> list(String... fileName) {
        return Stream.of(fileName).map(Resources::path).collect(Collectors.toList());
    }

    /**
     * Создает объект ресурсного файла
     */
    public static File file(String fileName) {
        return new File(path(fileName));
    }

}