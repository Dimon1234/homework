package homework.hw0224;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


class InsertionSortTest {

    @Test
    void alg() {
        int arr[] = new int[]{5, 7, 4, 2, 1, 0, 3, 6};
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7}, InsertionSort.alg(arr));
    }

}