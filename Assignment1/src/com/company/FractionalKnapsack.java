package com.company;
import java.util.*;
import java.util.stream.IntStream;


public class FractionalKnapsack {

    public static class Item {
        int value;
        int weight;
        double ratio;

        public Item(int value, int weight, double ratio) {
            this.value = value;
            this.weight = weight;
            this.ratio = ratio;
        }
    };

    private static double getOptimalValue(int capacity, Item[] items) {
        double finalvalue = 0;
        int i = 0;
        // either no items left or no room left
        while(i < items.length && capacity > 0) {
            // if item fits into knapsack, take all of it;
            // o.w. take so much as to fill the knapsack
            int fraction = Math.min(items[i].weight, capacity);
            finalvalue += items[i].ratio * fraction;
            capacity -= fraction;
            i++;
        }
        return finalvalue;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }

        Comparator<Item> comparator = new Comparator<Item>(){
            @Override
            public int compare (Item i1, Item i2) {
                return i1.ratio > i2.ratio ? -1 : 1;
            }
        };

        final Item[] sorted = IntStream.range(0, values.length)
                .mapToObj(i -> new Item(values[i], weights[i],
                       ((double) values[i]) / ((double) weights[i])))
                .sorted(comparator)
                .toArray(Item[]::new);


        System.out.println(getOptimalValue(capacity, sorted));
    }
} 
