package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by jacob.romero on 5/16/2017.
 */
public class IOExtendedApp {

    public static void main(String... args){

        Integer val = IntStream.range(1, 1001)
                .map(i -> CountToOneThousand.doCount(i))
                .sum();
        System.out.println("total count: " + val);

    }
}
