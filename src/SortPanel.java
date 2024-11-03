import javax.swing.*;
import java.awt.*;

public class SortPanel extends JPanel {
    private int[] array;
    private int currentIndex = -1; // Track the current index being processed
    private int compareIndex = -1; // Track the index being compared

    public void setArray(int[] array) {
        this.array = array;
        repaint();
    }

    public int[] getArray() {
        return array;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public void setCompareIndex(int compareIndex) {
        this.compareIndex = compareIndex;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (array != null) {
            int width = getWidth();
            int height = getHeight();
            int barWidth = width / array.length;

            for (int i = 0; i < array.length; i++) {
                int barHeight = array[i] * height / getMax();
                // Apply gradient color
                if (i == currentIndex) {
                    g.setColor(Color.RED); // Highlight the current index
                } else if (i == compareIndex) {
                    g.setColor(Color.BLUE); // Highlight the compared index
                } else {
                    g.setColor(new Color(0, (int) ((1.0 * array[i] / getMax()) * 255), 0));
                }
                g.fillRect(i * barWidth, height - barHeight, barWidth, barHeight);
            }
        }
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        setBackground(Color.WHITE);

        if (array != null) {
            int width = getWidth();
            int height = getHeight();
            int barWidth = width / array.length;

            for (int i = 0; i < array.length; i++) {
                int barHeight = array[i] * height / getMax();
                if (i == currentIndex) {
                    g2d.setColor(Color.RED); // Highlight the current index
                } else if (i == compareIndex) {
                    g2d.setColor(Color.BLUE); // Highlight the compared index
                } else {
                    g2d.setColor(new Color(0, (int) ((1.0 * array[i] / getMax()) * 255), 0));
                }
                g2d.fillRect(i * barWidth, height - barHeight, barWidth, barHeight);
            }
        }

    }

    private int getMax() {
        int max = Integer.MIN_VALUE;
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}
