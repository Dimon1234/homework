package homework.hw0304;


import java.util.stream.LongStream;


/**
 * Сортировка слиянием (нисходящая??)
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
     * @param workSpace - массив, на который ориентируемся
     * @param lowerBound - нижняя граница
     * @param upperBound - верхняя граница
     */
    private static void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {
        if (lowerBound != upperBound){
            int mid = (lowerBound + upperBound) / 2;
            recMergeSort(workSpace, lowerBound, mid);
            recMergeSort(workSpace, mid + 1, upperBound);
            merge(workSpace, lowerBound, mid + 1, upperBound);
        }
    }

    /**
     * 1. Проходим по двум половинкам массива двумя индексами (low и high)
     * 2. Заполняем массив workspace отсортированныйми элементами пока не закончатся элементы в одной из половинок
     * 3. Добавляем оставшиеся элементы либо с правой, либо с левой половинки
     * 4. Записываем результат мержа в исходный массив
     * <p>
     * @param workspace - массив, который будем сортировать
     * @param low - указатель для левой половины массива
     * @param high - указатель для правой половины массива
     * @param upperBound - верхняя граница (относительно ихсодного)
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
