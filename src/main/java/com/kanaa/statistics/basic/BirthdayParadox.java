package com.kanaa.statistics.basic;

import com.kanaa.mathan.matrix.sorting.Sorting;
import com.kanaa.measurement.RandomGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

/**
 * Парадокс двух дней рождений
 *
 *  В группе, состоящей из 23 или более человек, вероятность совпадения дней рождения (число и месяц) хотя бы у двух людей превышает 50 %.
 */
public class BirthdayParadox {

    public static final Predicate<List<Integer>> hasDuplicates = list -> {
        HashMap<Integer, Integer> duplicates = new HashMap<>();
        list.forEach(value -> {
            if (duplicates.containsKey(value)) {
                duplicates.put(value, duplicates.get(value) + 1);
            } else {
                duplicates.put(value, 1);
            }
        });
        return duplicates.values().stream().anyMatch(value -> value >= 2);
    };

    public static void main(String[] args) {
        final int EXPERIMENT_COUNT = 100;
        final int COUNT = 23;
        // Подготовка экспериментальных данных
        List<List<Integer>> experimentData = new ArrayList<>(EXPERIMENT_COUNT);
        for (int i = 0; i < EXPERIMENT_COUNT; i++) {
            List<Integer> list = RandomGenerator.generateIntegers(COUNT, 0, 366);
            Sorting.INSERTION.sort(list);
            experimentData.add(list);
        }
        // Проведение эксперимента
        List<Boolean> resultData = new ArrayList<>(EXPERIMENT_COUNT);
        for (List<Integer> data : experimentData) {
            boolean result = hasDuplicates.test(data);
            resultData.add(result);
            System.out.println((result ? "Совпадение " : "Нет совпадений") + data);
        }
        // Анализ результатов
        long positiveCount = resultData.stream()
                .filter(value -> value)
                .count();
        double probability = (double) positiveCount / EXPERIMENT_COUNT;
        System.out.printf("Вероятность положительного результата: %f \n", probability);
    }
}
