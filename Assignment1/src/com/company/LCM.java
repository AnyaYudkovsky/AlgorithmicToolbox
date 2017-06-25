package com.company;
import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }

//  private static long lcm_fast(int a, int b) {
//    for (long l = 1; l <= (long) a * b; ++l)
//      if (l % a == 0 && l % b == 0)
//        return l;
//
//    return (long) (a * b)/gcd_fast ;
//  }

  private static long gcd_fast(long a, long b) {

    if (a<=0) return 1;

    if (b<=0)
      return a;
    else
      return (a>b)? gcd_fast(b, a%b): gcd_fast(a, b%a);

  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    long a = scanner.nextLong();
    long b = scanner.nextLong();

    //System.out.println(gcd_fast(a, b));
    System.out.println((a*b)/gcd_fast(a,b) );
  }
}
