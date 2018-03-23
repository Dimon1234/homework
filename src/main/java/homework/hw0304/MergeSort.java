package homework.hw0304;

/**
 * Нисходящая сортировка слиянием
 */
public class MergeSort {

    private static long[] array;

    public static long[] getSortedArray(long[] array) {
        MergeSort.array = array;
        mergeSort();
        return MergeSort.array;
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
        if (lowerBound < upperBound) {
            int mid = lowerBound + (upperBound - lowerBound) / 2;
            recMergeSort(workSpace, lowerBound, mid);
            recMergeSort(workSpace, mid + 1, upperBound);
            Merge.go(array, workSpace, lowerBound, mid, upperBound);
        }
    }

}
