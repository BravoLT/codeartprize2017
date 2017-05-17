package com.example;

/**
 * Created by jacob.romero on 5/16/2017.
 */
public class CountToOneThousand {

    public static String[] numWord = new String[] {
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };
    public static String[] teensWord = new String[] {
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };
    public static String[] tensWord = new String[] {
            "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };



    public static Integer doCount(Integer num){
        Integer totalCount = 0;
        if(num.equals(1000)){
            return "onethousand".length();
        }
        else if(num > 99 && num < 1000){
            totalCount += hundredsWordCount(num);
            totalCount += tensWordCount(num % 100);
        }

        else{
            totalCount += tensWordCount(num);
        }
        return totalCount;
    }


    public static Integer getHundreds(Integer num){
        if(num < 1000 && num > 99){
            return num / 100;
        }
        else{
            return 0;
        }
    }



    private static Integer tensWordCount(Integer num) {
        Integer totalCount = 0;
        if(num > 9 && num < 20){
            return teensWord[num - 10].length();
        }
        else if(num > 19){
            totalCount += tensWord[num / 10 - 2].length();
            totalCount += numWord[num % 10].length();
        }
        else{
            totalCount += numWord[num].length();
        }
        return totalCount;
    }

    private static Integer hundredsWordCount(Integer num) {
        Integer totalcount = 0;
//        System.out.println("div: " + String.valueOf(980 % 100 ));
        if(num % 100 > 0){

            totalcount += "and".length();
        }

        Integer hundredsDigit = getHundreds(num);
        totalcount += numWord[hundredsDigit].length() + "hundred".length();
        return totalcount;
    }
}
