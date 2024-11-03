public class BubbleSort extends SortingAlgorithm {
    @Override
    public void sort(int[] array, SortPanel panel) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                    repaintPanel(panel);
                }
            }
        } while (swapped);
        panel.setCurrentIndex(-1);
        panel.setCompareIndex(-1);


    }
    @Override
    public String getTimeComplexity() {
        return "O(n^2)";
    }
}
