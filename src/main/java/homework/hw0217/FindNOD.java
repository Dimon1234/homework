package homework.hw0217;

import java.math.BigInteger;

/**
 * Homework 17.02.2018.
 */
public class FindNOD {
    /**
     * Наибольший Общий Делитель (рекурсия)
     * @param a первое число
     * @param b второе число
     */
    public static void findNODRecursive(int a, int b) {

        if (a == b) System.out.println(a);
        if (a > b) findNODRecursive(a - b, b);
        if (a < b) findNODRecursive(a, b - a);
    }

    /**
     * Алгоритм Евклида
     */
    public static void findNodIter(BigInteger a, BigInteger b)
    {
        while (a.longValue() != 0 && b.longValue() !=0)
        {
            if ((a.compareTo(b)) > 0) a = a.remainder(b);
            else b = b.remainder(a);
        }
        System.out.println("result is "+a.add(b));
    }
}
