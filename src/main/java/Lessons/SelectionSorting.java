package Lessons;

/**
 * 24.02.2018
 * Сортировка выбором
 */

public class SelectionSorting {

    public static void main(String[] args) {
        int a [] = new int[]{6,5,4,7,3,8,5,2,1,0};
        selection(a);

    }
    private static void selection(int [] arr)
    {
        int min = 0;
        for (int j = 0; j < arr.length; j++) {
            //находим минимальный от j до конца массива
            for (int i = j; i < arr.length; i++) {
                if (arr[i] < arr[min]) min = i;
            }
            //меняем минимальный элемент местами с j-ым
            exchange(arr,j,min);
        }

        for (int anArr : arr) System.out.print(anArr + " ");

    }

    /**
     * Меняет местами arr[a] и arr[b]
     * @param arr массив
     * @param a первое неотсортированное число
     * @param b минимальное в неотсортированной части массива
     */
    private static void exchange(int[] arr, int a, int b)
    {
        int a1 = arr[a];
        arr[a] = arr[b];
        arr[b] = a1;

    }

}
