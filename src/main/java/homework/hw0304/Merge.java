package homework.hw0304;

public class Merge {

    public static void go(long[] array, long[] workspace, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;

        System.arraycopy(array, low, workspace, low, high + 1 - low);

        for (int k = low; k <= high; k++) {
            if (i > mid) array[k] = workspace[j++];
            else if (j > high) array[k] = workspace[i++];
            else if (workspace[i] < workspace[j]) array[k] = workspace[i++];
            else array[k] = workspace[j++];
        }

    }
}
