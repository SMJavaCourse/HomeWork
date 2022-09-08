package org.course.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Scanner;

@Getter
@AllArgsConstructor
public class SearchInput {
    String nameOfHotel;
    String command;
    String errorMessage;
    int numberOfGuests;


    public static int[] firstArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    public static int[] secondArray = new int[]{10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
    public static int[] resultArray;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int N = console.nextInt();
        int[] array = new int[N];
        if (N > 0) {
            for (int i = 0; i < N; i++) {
                array[i] = console.nextInt();
            }
        }
        if (N % 2 -= 0) {
            for (int i = array.length - 1; i >= 0; i--) {
                System.out.println(array[i]);
            }
        } else {
            for (int i = 0; i < array.length - 1; i++) {
                System.out.println(array[i]);
            }
        }
    }
}
