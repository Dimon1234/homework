package Lessons;


public class Fibonacci {

    public static void fibWithFizBus(int n) {
        int[] mass = new int[n];
        mass[0] = 1;
        mass[1] = 1;
        System.out.print(1 + " ");
        System.out.print(1 + " ");
        for (int i = 2; i < n; i++) {
            mass[i] = mass[i - 1] + mass[i - 2];
            if (mass[i] % 3 == 0) System.out.print("Fiz ");
            if (mass[i] % 5 == 0) System.out.print("Bus ");
            else System.out.print(mass[i] + " ");
        }
    }
    /**
     * магия комплексных чисел
     */
    public static long fibonacci(long n) {
        return (long)((Math.pow((1 + Math.sqrt(5)) / 2, n) - Math.pow((1 - Math.sqrt(5)) / 2, n)) / Math.sqrt(5));
    }
}
