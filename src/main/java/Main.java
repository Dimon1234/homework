import com.sun.javafx.binding.SelectBinding;
import homework.hw0304.MergeSortV2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.LongStream;


public class Main {
    public static void main(String[] args) {
       long [] result =  MergeSortV2.getSortedArray(new long[]{6,5,4,3,2,1});

        LongStream.of(result).forEach(System.out::print);
    }
}
