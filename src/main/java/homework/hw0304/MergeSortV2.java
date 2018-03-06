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
        recMergeSort(workSpace, 0, workSpace.length - 1);
    }

    /**
     * 1. Если нижняя граница не равна верхней (если массив поделен до одного элемента),то
     * 2. сортируем левую половину и правую половину
     * 3. мёржим две половины
     * <p>
     *
     * @param workSpace  - массив, на который ориентируемся
     * @param lowerBound - нижняя граница
     * @param upperBound - верхняя граница
     */
    private static void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {
        if (lowerBound != upperBound) {
            int mid = (lowerBound + upperBound) / 2;
            recMergeSort(workSpace, lowerBound, mid);
            recMergeSort(workSpace, mid + 1, upperBound);
            merge(workSpace, lowerBound, mid + 1, upperBound);
        }
    }

    /**
     * реализовать версию merge которая копирует вторую половину массива a[] в temporary массив в
     * убывающем порядке а затем слияние назад в a[].
     * Это изменение позволяет не использовать во внутреннем цикле код проверки, не закончилась ли каждая половина
     */
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
