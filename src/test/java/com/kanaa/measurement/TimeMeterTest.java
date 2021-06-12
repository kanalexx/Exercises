package com.kanaa.measurement;

import com.kanaa.mathan.matrix.sorting.Sorting;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author Alexander Kanunnikov
 */
public class TimeMeterTest {

    @Test
    public void writeDuration() {
        TimeMeter timeMeter = new TimeMeter(System.out);
        timeMeter.writeDuration("5", () -> Sorting.MERGE.sort(Arrays.asList(5, 1, 4, 2, 3)));
    }
}