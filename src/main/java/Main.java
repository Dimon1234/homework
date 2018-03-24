import homework.hw0304.MergeSort;
import homework.hw0304.MergeSortV2;

public class Main {
    public static void main(String[] args) {
        long [] arr = new long[]{8,7,6,5,4,3,2,1};
        MergeSortV2.getSortedArray(arr);
        for (long a : arr) System.out.print(a+" ");
    }
}
