package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;


/**
 * @link http://codeforces.com/problemset/problem/961/B
 */
public class Sleep {

    public static void main(String args[]) throws IOException {
        long a = System.currentTimeMillis();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = reader.readLine().split(" ");
        String[] secondLine = reader.readLine().split(" ");
        String[] thirdLine = reader.readLine().split(" ");

        int N = Integer.parseInt(firstLine[0]);
        int K = Integer.parseInt(firstLine[1]);

        List<Integer> listOfLecture = Arrays.stream(secondLine).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> listOfActivity = Arrays.stream(thirdLine).map(Integer::parseInt).collect(Collectors.toList());

        int sum = 0;
        int bestIndex = findBestIndex(listOfLecture, K);
        System.err.println(bestIndex);
        for (int i = 0; i < N; i++) {
            if (i >= bestIndex && i < bestIndex + K) {
                sum += listOfLecture.get(i);
                continue;
            }
            if (listOfActivity.get(i) == 1) sum += listOfLecture.get(i);
        }

        long b = System.currentTimeMillis();
        System.out.println(sum);
        System.err.println(b - a);
    }

    public static int findBestIndex(List<Integer> list, int K) {
        int index = 0;
        int sum;
        Stack<Integer> result = new Stack<>();

        for (int i = 0; i < list.size()-K+1; i++) {
            sum = list.subList(i, i+K).stream().mapToInt(Integer::intValue).sum();
            if (!result.empty() && result.peek() < sum) {
                index = i;
                result.push(sum);
            }
            if (result.empty())
            {
                index = i;
                result.push(sum);
            }

        }

        return index;
    }
}