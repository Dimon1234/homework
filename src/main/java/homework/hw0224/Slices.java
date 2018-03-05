package homework.hw0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * Homework 24.02.2018
 */
public class Slices {
    private static ArrayList<Integer> list = new ArrayList<>();
    private static int N;


    static {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            //инициализирую список с консоли
            Arrays.asList(reader.readLine().split(" ")).forEach(s -> list.add(Integer.parseInt(s)));
            //считываю N в следующей строке
            N = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            System.err.print("incorrect input");
        }
    }

    /**
     * Как работает алгоритм:
     * 1. Создаю очередь размера N (условно)
     * 2. Добавляю N элементов из списка в очередь
     * 3. С этого момента начинаю искать максимум в очереди с помощью стека (method findMaxInStack)
     * 4. После нахождения удаляю первый элемент в очереди и иду дальше по списку
     */
    public static String maxListSlices() {
        StringBuilder result = new StringBuilder();
        Queue<Integer> queue = new ArrayDeque<>();

        int i = 0;
        for (Integer num : list) {
            queue.add(num);
            i++;
            if (i >= N) {
                result.append(findMaxInStack(queue)).append(" ");
                queue.remove();
            }
        }
        return result.toString().trim();
    }

    private static int findMaxInStack(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        stack.push(queue.element()); //инициализвация

        queue.forEach(i ->
        {
            if (stack.peek() < i) stack.push(i);
        });

        return stack.peek();
    }

}
