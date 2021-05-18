package com.kanaa.measurement;

import com.kanaa.Resources;
import com.kanaa.mathan.matrix.sorting.Sorting;
import org.openjdk.jmh.annotations.*;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 2)
@Measurement(iterations = 2)
public class MyBenchmark {

    private List<Integer> list;

    private static List<Integer> cachedList;

    static {
        try {
            cachedList = readListFromFile(Resources.path("100000.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static List<Integer> readListFromFile(String fileName) throws IOException {
        Stream<String> lines = Files.lines(Paths.get(fileName));
        List<Integer> list = new ArrayList<>();
        lines.forEach((value) -> list.add(Integer.parseInt(value)));
        return list;
    }

    @Setup(Level.Invocation)
    public void setup() throws IOException {
        list = new ArrayList<>();
        list.addAll(cachedList);
    }

    @Benchmark
    public void MergeSort() {
        Sorting.MERGE.sort(list);
    }

    @Benchmark
    public void InsertionSort() {
        Sorting.INSERTION.sort(list);
    }
}
