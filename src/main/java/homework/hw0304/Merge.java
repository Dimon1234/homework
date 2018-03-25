package homework.hw0304;

public class Merge {

    public static void go(long[] array, long[] workspace, int low, int mid, int high) {
        int i = low;
        int j = high;

        for (int k = low; k < mid + 1; k++) {
            workspace[k] = array[k];
        }
        for (int k = mid + 1; k <= high; k++) {
            workspace[k] = array[high + mid + 1 - k];
        }


        for (int k = low; k <= high; k++) {
            if (workspace[i] < workspace[j]) array[k] = workspace[i++];
            else array[k] = workspace[j--];
        }

    }
}
