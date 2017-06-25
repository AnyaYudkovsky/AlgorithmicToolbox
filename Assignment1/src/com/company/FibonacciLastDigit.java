package com.company;
import java.util.*;

public class FibonacciLastDigit {

    private static long getFibonacciLastDigitFast(int n) {
        if (n <= 1)
            return n;

        long a = 1;
        long b = 1;
        long[] sequence = new long[n];

        for (int i = 0; i < n; i++) {
            sequence[i] = a;

            long temp = a % 10;
            a = b;
            b = (temp + b) % 10;
        }
        return sequence[n-1];
    }

    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % 10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long c = getFibonacciLastDigitFast(n);
        System.out.println(c);
    }
}

