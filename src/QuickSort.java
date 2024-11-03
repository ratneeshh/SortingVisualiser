public class QuickSort extends SortingAlgorithm {
    @Override
    public void sort(int[] array, SortPanel panel) {
        quickSort(array, 0, array.length - 1, panel);
    }

    private void quickSort(int[] array, int low, int high, SortPanel panel) {
        if (low < high) {
            int pi = partition(array, low, high, panel);
            quickSort(array, low, pi - 1, panel);
            quickSort(array, pi + 1, high, panel);
        }
    }

    private int partition(int[] array, int low, int high, SortPanel panel) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                repaintPanel(panel);
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        repaintPanel(panel);
        return i + 1;


    }
    @Override
    public String getTimeComplexity() {
        return "O(n log n)";
    }
}
