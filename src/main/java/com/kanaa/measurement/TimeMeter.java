package com.kanaa.measurement;

import java.io.PrintStream;

/**
 * Замер времени выполнения метода
 *
 * <br> Метод должен быть обернут в Runnable.
 * <br> Результат замеров записывается в writer.
 * @author Alexander Kanunnikov
 */

public class TimeMeter {

    private PrintStream writer;
    private String delimiter;

    public TimeMeter(PrintStream writer) {
        this(writer, ";");
    }

    public TimeMeter(PrintStream writer, String delimiter) {
        this.writer = writer;
        this.delimiter = delimiter;
    }

    /**
     * Замеряет время выполнения метода Runnable#run() в мс
     * @param caption     - подпись к замеру
     * @param runnable    - замеряемый метод
     */
    public void writeDuration(String caption, Runnable runnable) {
        final long startTime = System.currentTimeMillis();
        runnable.run();
        final long finishTime = System.currentTimeMillis();
        String out = caption + delimiter + (finishTime - startTime);
        writer.println(out);
    }
}