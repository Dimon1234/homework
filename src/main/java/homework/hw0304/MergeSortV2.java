package homework.hw0304;

/**
 ***Как ведет себя алгоритм если все значения одинаковые?
 * В моей реализации при каждом merge сначала записывает все элементы из правой половины, потом все из левой.
 *
 ***Определить нижнюю границу сложности алгоритма?
 * Лучше всего алгоритм должен проявить себя когда на вход ему придет уже отсортированный массив
 * (или массив из одинаковых элементов)
 * В этом случае выполнятся все те же log2(n) делений массива, те же 2 цикла while (до n) и один цикл for (итого 2*n*log2(n))
 * То есть, сложность в лучшем случае тоже будет равна n*log(n)
 *
 */


/**
 * Восходящая сортировка слиянием
 */
public class MergeSortV2 {
    private static long[] array;

    public static long[] getSortedArray(long[] array) {
        MergeSortV2.array = array;
        mergeSort();
        return MergeSortV2.array;
    }

    /**
     * init-вызов
     */
    private static void mergeSort() {
        long[] workSpace = array.clone();
        iterMergeSort(workSpace, workSpace.length - 1);
    }

    /**
     * Идея алгоритма в том, чтобы не разбивать массив на половинки, а
     * рассматривать его как уже разбитый подсписки длиной 1.
     * Внешний цикл устанавливает размер подсписка = m и мёржит
     * эти подсписки попарно
     * @param workSpace исходный массив
     * @param upperBound верхняя граница массива
     */
    
    private static void iterMergeSort(long[] workSpace, int upperBound) {
        for (int m = 1; m <= upperBound; m = m+m)
            for (int i = 0; i <= upperBound-m; i += m+m)
                merge(workSpace, i, i+m, Math.min(i+m+m-1, upperBound));

    }

    
    private static void merge(long[] workspace, int low, int high, int upperBound) {
        int j = 0;
        int lowerBound = low; //индекс нижней границы относительно исходного массива
        int mid = high - 1; //индекс середины
        int n = upperBound - lowerBound + 1; // количество элементов

        while (low <= mid && high <= upperBound) { //1
            if (array[low] < array[high]) workspace[j++] = array[low++];  //2
            else workspace[j++] = array[high++];
        }
        while (low <= mid) workspace[j++] = array[low++]; //3

        while (high <= upperBound) workspace[j++] = array[high++]; //3

        for (j = 0; j < n; j++) {
            array[lowerBound + j] = workspace[j];
        }
    }

}
