package com.pschmeltzerioext17;

import com.google.common.collect.ImmutableMap;

import java.util.Map;
import java.util.stream.IntStream;

/**
 * Created by Peter.schmeltzer on 5/17/2017.
 */
public class Challenge {

    private static final Map<Integer,String> numberMap =
            ImmutableMap.<Integer,String>builder()
                    .put(1,"one").put(2,"two").put(3,"three").put(4,"four").put(5,"five")
                    .put(6,"six").put(7,"seven").put(8,"eight").put(9,"nine").put(10,"ten")
                    .put(11,"eleven").put(12,"twelve").put(13,"thirteen").put(14,"fourteen").put(15,"fifteen")
                    .put(16,"sixteen").put(17,"seventeen").put(18,"eighteen").put(19,"nineteen").put(20,"twenty")
                    .put(30,"thirty").put(40,"forty").put(50,"fifty").put(60,"sixty").put(70,"seventy")
                    .put(80,"eighty").put(90,"ninety")
                    .build();

    public static void main(String[] args) {
        new Challenge().run();
    }

    private void run(){
        System.out.println("Result: " + IntStream.rangeClosed(1, 1000) /* Create stream */
                .mapToObj(this::getNumberAsWords)/* Convert to words */
                .peek(System.out::println)/* Peek on console */
                .mapToInt(String::length)/* Get length */
                .sum());/* Find sum */
    }


    /*Capable of getting string rep for any number under 1000*/
    private String getNumberAsWords(int i){

        if(i <= 20){
            return numberMap.get(i);
        }

        if(i >= 20 && i < 100){
            String asString = String.valueOf(i);
            int tens = Integer.valueOf(String.valueOf(asString.charAt(0))) * 10;
            int ones = Integer.valueOf(String.valueOf(asString.charAt(1)));
            return numberMap.get(tens) + (ones == 0 ? "" : numberMap.get(ones));
        }

        if(i >= 100 && i < 1000){
            String asString = String.valueOf(i);
            int hundreds = Integer.valueOf(String.valueOf(asString.charAt(0)));
            int tens = Integer.valueOf(String.valueOf(asString.charAt(1))) * 10;
            int ones = Integer.valueOf(String.valueOf(asString.charAt(2)));
            return getNumberAsWords(hundreds) + "hundred" + (tens + ones == 0 ? "" : "and" + getNumberAsWords(tens + ones));
        }

        if(i == 1000){
            return "onethousand";
        }

        throw new UnsupportedOperationException("Not supported greater than 1000");
    }


}
