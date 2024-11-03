public class InsertionSort extends SortingAlgorithm {
    @Override
    public void sort(int[] array, SortPanel panel) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
                repaintPanel(panel);
            }
            array[j + 1] = key;
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
