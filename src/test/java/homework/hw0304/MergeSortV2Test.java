package homework.hw0304;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortV2Test {

    @Test
    void getSortedArray() {
        long [] arr = new long[]{8,7,5,4,6,2,3,1};
        Assert.assertArrayEquals(new long[]{1,2,3,4,5,6,7,8},MergeSortV2.getSortedArray(arr));
    }
}