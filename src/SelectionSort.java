public class SelectionSort extends SortingAlgorithm {
    @Override
    public void sort(int[] array, SortPanel panel) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
            repaintPanel(panel);
        }
        panel.setCurrentIndex(-1);
        panel.setCompareIndex(-1);
    }
    @Override
    public String getTimeComplexity() {
        return "O(n^2)";
    }
}
