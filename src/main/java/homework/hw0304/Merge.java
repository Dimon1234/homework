package homework.hw0304;

public class Merge {

    private long[] array;

    public Merge(long[] array, long[] workspace, int low, int high, int upperBound) {
        this.array = array;
        merge(workspace,low,high,upperBound);
    }

    /**
     * 1. Проходим по двум половинкам массива двумя индексами (low и high)
     * 2. Заполняем массив workspace отсортированныйми элементами пока не закончатся элементы в одной из половинок
     * 3. Добавляем оставшиеся элементы либо с правой, либо с левой половинки
     * 4. Записываем результат мержа в исходный массив
     * <p>
     *
     * @param workspace  - массив, который будем сортировать
     * @param low        - указатель для левой половины массива
     * @param high       - указатель для правой половины массива
     * @param upperBound - верхняя граница (относительно исходного)
     */
    private void merge(long[] workspace, int low, int high, int upperBound) {
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
