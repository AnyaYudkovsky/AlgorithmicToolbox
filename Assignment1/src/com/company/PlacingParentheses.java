package com.company;

import java.util.Scanner;

public class PlacingParentheses {

    private static long getMaximValue(String exp) {

        int n = exp.length() / 2 + 1;

        int[][] minimum = new int[n][n], maximum = new int[n][n];

        for(int i = 0; i < n; i++) {
            minimum[i][i] = exp.charAt(i * 2) - '0';
            maximum[i][i] = exp.charAt(i * 2) - '0';
        }

        for(int size = 1; size <= n - 1; size++) {

            for(int i = 0; i <= n - 1 - size; i++) {
                int j = size + i;
                int[] res = getMinMax(exp, i, j, minimum, maximum);
                minimum[i][j] = res[0];
                maximum[i][j] = res[1];
            }
        }

        return maximum[0][n - 1];
    }

    private static int[] getMinMax(String exp, int i, int j,
                                      int[][] minimum,
                                      int[][] maximum) {
        int[] res = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        for(int index = i; index <= j - 1; index++) {

            char operator = exp.charAt(index * 2 + 1);

            long a = eval(minimum[i][index], minimum[index + 1][j], operator);
            long b  = eval(minimum[i][index], minimum[index + 1][j], operator);
            long c  = eval(maximum[i][index], minimum[index + 1][j], operator);
            long d  = eval(maximum[i][index], maximum[index + 1][j], operator);

            res[0] = (int) Math.min(a, Math.min(b,
                    Math.min(c, Math.min(d, res[0]))));
            res[1] = (int) Math.max(a, Math.max(b,
                    Math.max(c, Math.max(d, res[1]))));
        }
        return res;
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
        scanner.close();
    }
}

