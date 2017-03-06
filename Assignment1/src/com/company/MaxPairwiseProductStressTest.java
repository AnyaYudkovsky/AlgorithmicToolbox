package com.company;

import java.util.*;
import java.util.Random.*;

public class MaxPairwiseProductStressTest {


    static long getMaxPairwiseProductFast(long[] numbers) {

        long largestA = numbers[0];
        long largestB = -1;
        int maxi1 = 0;
        int maxi2 = -1;

        for(int i = 0; i < numbers.length; i++){

            if(numbers[i] > largestA){
                largestB = largestA;
                largestA = numbers[i];
                maxi1 = i;
            }
            else if (numbers[i] > largestB || maxi1 == maxi2) {
                largestB = numbers[i];
                maxi2 = i;
            }
        }

        return largestB * largestA;
    }
    static long getMaxPairwiseProduct(long[] numbers) {
        long result = 0;
        long res1 = 0;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                res1 = numbers[i] * numbers[j];
                if ( res1 > result ) {
                    result = res1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        Random r = new Random();

        while (true) {
            int n = r.nextInt(100) + 2;
            long[] numbers = new long[n];

            for (int i = 0; i < n; ++i) {
                numbers[i] = r.nextInt(100000);
            }
            for (int i = 0; i < n; ++i) {
                System.out.print(numbers[i]);
                System.out.print(" ");
            }
            System.out.println();
            System.out.println(n);
            long res1 = getMaxPairwiseProduct(numbers);
            long res2 = getMaxPairwiseProductFast(numbers);
            if (res1 != res2) {
                System.out.println("Wrong answer: " + res1 + " " + res2);
            }
            else {
                System.out.println("OK");
            }
        }


    }

}