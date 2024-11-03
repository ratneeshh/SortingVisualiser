public abstract class SortingAlgorithm {
    protected void repaintPanel(SortPanel panel) {
        panel.repaint();
        try {
            Thread.sleep(50); // Adjust the delay as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public abstract void sort(int[] array, SortPanel panel);
    public abstract String getTimeComplexity();

}
