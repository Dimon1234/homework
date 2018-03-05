package homework.hw0224;


/**
 * Алгоритм:
 * 1. Иду от первого элемента в массиве
 * 2. Если следующий элемент меньше предыдущего, то его надо сортировать
 * 3. Иду от того элемента, который хочу отсортировать и до начала массива
 * 4. Перемещаю его к началу массива пока не станет на свое место
 */
public class InsertionSort {


    public static int[] alg(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) { //1
            if (arr[i + 1] < arr[i]) {             //2
                for (int j = i + 1; j > 0; j--) {  //3
                    if (arr[j] < arr[j - 1]) swap(arr, j, j - 1); //4
                }
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int a = arr[i];
        arr[i] = arr[j];
        arr[j] = a;
    }
}
