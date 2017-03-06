package com.company;
import java.util.*;
import java.io.*;
import java.util.Random.*;

public class MaxPairwiseProduct {


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

        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        long[] numbers = new long [n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println(getMaxPairwiseProductFast(numbers));


    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}