package com.company;
import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
    if (n <= 1)
      return n;

    return calc_fib(n - 1) + calc_fib(n - 2);
  }

  private static long calc_fib_fast(int n) {
    if (n <= 1)
      return n;

      long a = 1;
      long b = 1;
      long[] sequence = new long[n];

      // Fill array with Fibonacci values.
      for (int i = 0; i < n; i++) {
        sequence[i] = a;

        long temp = a;
        a = b;
        b = temp + b;
      }
      return sequence[n-1];
    }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    //System.out.println(calc_fib(n));
    System.out.println(calc_fib_fast(n));
  }
}
