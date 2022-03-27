package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class ass1 {
    static Scanner sc = new Scanner(System.in);
    static int totalResult = 0;
    static int number = sc.nextInt();
    static int[] arr = new int[number];

    public static void main(String[] args) {
        for (int i = 0; i < number; i++) arr[i] = i + 1;
        permute(arr, 0);
        System.out.println(totalResult);
    }

    public static void permute(int[] arr, int k) {
        for (int i = k; i < arr.length; i++) {
            swap(arr, i, k);
            permute(arr, k + 1);
            swap(arr, k, i);
        }
        if (k == arr.length - 1) {
            System.out.print(Arrays.toString(arr) + " ");
            sumBetweenNums(arr);
        }
    }

    public static void sumBetweenNums(int[] arr) {
        int result = 1;

        for (int i = 0; i < arr.length - 1; i++) {
            result = result * (Math.abs(arr[i] - arr[i + 1]));
        }
        System.out.println(result);

        if (result < factorial(number)) totalResult++;
    }

    public static void swap(int[] arr, int numOne, int numTwo) {
        int t = arr[numOne];
        arr[numOne] = arr[numTwo];
        arr[numTwo] = t;
    }

    public static int factorial(int num) {
        if (num >= 1) return num * factorial(num - 1);
        return 1;
    }
}