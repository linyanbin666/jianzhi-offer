package com.horizon.chapter2;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void sort(int[] data, int start, int end) {
        if (start == end)
            return;
        int index = partition(data, start, end);
        if (index > start) {
            sort(data, start, index - 1);
        }
        if (index < end) {
            sort(data, index + 1, end);
        }
    }

    private static int partition(int[] data, int start, int end) {
        if (data == null || data.length == 0 || start < 0 || end >= data.length)
            throw new RuntimeException("invalid parameters");

        int index = randomIndex(start, end);
        swap(data, index, end);

        int low = start - 1;
        for (int i = start; i < end; i++) {
            if (data[i] < data[end]) {
                low++;
                if (low != i) {
                    swap(data, low, i);
                }
            }
        }
        low++;
        swap(data, low, end);
        return low;
    }



    private static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    private static int randomIndex(int start, int end) {
        return new Random().nextInt(end - start + 1) + start;
    }

    public static void main(String[] args) {
        int[] data = {5, 3, 9, 2, 10, 12, 1};
        QuickSort.sort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }

}
