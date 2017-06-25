package com.company;
import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        //write your code here
//        int[] points = new int[2 * segments.length];
//        for (int i = 0; i < segments.length; i++) {
//            points[2 * i] = segments[i].start;
//            points[2 * i + 1] = segments[i].end;
//        }

        List<Integer> points = new ArrayList<>();
        int i = 0, n = segments.length;
        while (i < n) {
            int right = segments[i].end;
            points.add(right);
            while (i < n &&  segments[i].start <= right &&
                    right <= segments[i].end)
                i++;
        }

        int[] result = new int[points.size()];
        for(int j = 0; j < points.size(); j++)
            result[j] = points.get(j);
        return result;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }

        Arrays.sort(segments, new Comparator<Segment>(){
            @Override
            public int compare(Segment segment1, Segment segment2) {
                return segment1.end - segment2.end;
            }
        });

        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
