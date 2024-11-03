public class MergeSort extends SortingAlgorithm {
    @Override
    public void sort(int[] array, SortPanel panel) {
        mergeSort(array, 0, array.length - 1, panel);
    }

    private void mergeSort(int[] array, int left, int right, SortPanel panel) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid, panel);
            mergeSort(array, mid + 1, right, panel);
            merge(array, left, mid, right, panel);
        }
    }

    private void merge(int[] array, int left, int mid, int right, SortPanel panel) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, mid + 1, rightArray, 0, n2);

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
            repaintPanel(panel);
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
            repaintPanel(panel);
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
            repaintPanel(panel);
        }
        panel.setCurrentIndex(-1);
        panel.setCompareIndex(-1);
    }
    @Override
    public String getTimeComplexity() {
        return "O(n log n)";
    }
}
