package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //ex1();
        //ex2();
        //ex3();
    }
    static void ex1() {
        /*
        Пусть дан произвольный список целых чисел, удалить из него четные числа
         */
       List<Integer> list1 = new ArrayList<>();
        Collections.addAll(list1, 1, 5, 6, 11, 2, 3, 4, 9, 7, 8, 10);
        System.out.println("Исходный список: " + list1);
        for (int i = 0; i < list1.size(); i++) {
            if(list1.get(i) % 2 == 0) {
                list1.remove(i);
                i--;
            }
        }
        System.out.println("Преобразованный список: " + list1);

    }

    static void ex2() {
        /*
        Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка.
        Collections.max()
         */
        List<Integer> list1 = new ArrayList<>();
        list1.add(1000);
        list1.add(2000);
        list1.add(3000);
        list1.add(4000);
        System.out.println("Список: " + list1);


        Integer maxNum = Collections.max(list1);
        System.out.println("Максимальное число: " + maxNum);

        Integer minNum = Collections.min(list1);
        System.out.println("Минимальное число: " + minNum);

        double avg = getAverage(list1);
        System.out.println("Среднее арифметическое: " + avg);

    }
    static double getAverage(List<Integer> list) {

        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return list.size() > 0 ? (double) sum / list.size() : 0;
    }

    static void ex3(){
        /*
        Реализовать алгоритм сортировки слиянием
         */
        int[] arr = {2, 9, 5, 4, 8, 1, 6, -5, 1000, 44, -23};
        mergeSort(arr);

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");

    }
    static void mergeSort(int[] arr) {
        int n = arr.length;
        if (n == 1) return;

        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        for (int i = 0; i < mid; i++)
            left[i] = arr[i];
        for (int j = mid; j < n; j++)
                right[j - mid] = arr[j];
              mergeSort(left);
              mergeSort(right);
              merge(arr, left, right);

    }
    static void merge(int[] arr, int[] l, int[] r) {
        int left = l.length;
        int right = r.length;
        int i = 0;
        int j = 0;
        int idx = 0;

        while(i < left && j < right){
            if(l[i] < r[j]){
                arr[idx] = l[i];
                i++;
                idx++;
            } else{
                arr[idx] = r[j];
                j++;
                idx++;
            }
        }

        for (int ll = i; ll < left; ll++)
            arr[idx++] = l[ll];

        for(int rr = j; rr < right; rr++)
            arr[idx++] = r[rr];


    }


}
