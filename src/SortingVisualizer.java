import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortingVisualizer {
    private JFrame frame;
    private JTextField arrayInputField;
    private JComboBox<String> algorithmComboBox;
    private SortPanel sortPanel;
    private SortingAlgorithm currentAlgorithm;
    private JLabel timeComplexityLabel;

    public SortingVisualizer() {
        frame = new JFrame("Sorting Algorithm Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        arrayInputField = new JTextField(20);
        JButton setArrayButton = new JButton("Set Array");

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter array:"));
        inputPanel.add(arrayInputField);
        inputPanel.add(setArrayButton);

        frame.add(inputPanel, BorderLayout.NORTH);

        String[] algorithms = {"Bubble Sort", "Insertion Sort", "Merge Sort", "Quick Sort", "Selection Sort"};
        algorithmComboBox = new JComboBox<>(algorithms);

        JButton startButton = new JButton("Start");

        timeComplexityLabel = new JLabel("Time Complexity: ");

        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("Select algorithm:"));
        controlPanel.add(algorithmComboBox);
        controlPanel.add(startButton);
        controlPanel.add(timeComplexityLabel);

        frame.add(controlPanel, BorderLayout.SOUTH);

        sortPanel = new SortPanel();
        frame.add(sortPanel, BorderLayout.CENTER);

        setArrayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = arrayInputField.getText();
                String[] inputStrings = inputText.split("\\s+");
                int[] array = new int[inputStrings.length];
                try {
                    for (int i = 0; i < inputStrings.length; i++) {
                        array[i] = Integer.parseInt(inputStrings[i]);
                    }
                    sortPanel.setArray(array);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input! Please enter a space-separated list of integers.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedAlgorithm = (String) algorithmComboBox.getSelectedItem();
                int[] array = sortPanel.getArray();
                if (selectedAlgorithm != null && array != null) {
                    switch (selectedAlgorithm) {
                        case "Bubble Sort":
                            currentAlgorithm = new BubbleSort();
                            timeComplexityLabel.setText("Time Complexity: O(n^2)");
                            break;
                        case "Insertion Sort":
                            currentAlgorithm = new InsertionSort();
                            timeComplexityLabel.setText("Time Complexity: O(n^2)");
                            break;
                        case "Merge Sort":
                            currentAlgorithm = new MergeSort();
                            timeComplexityLabel.setText("Time Complexity: O(n log n)");
                            break;
                        case "Quick Sort":
                            currentAlgorithm = new QuickSort();
                            timeComplexityLabel.setText("Time Complexity: O(n log n)");
                            break;
                        case "Selection Sort":
                            currentAlgorithm = new SelectionSort();
                            timeComplexityLabel.setText("Time Complexity: O(n^2)");
                            break;
                    }
                    new Thread(() -> currentAlgorithm.sort(array, sortPanel)).start();
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SortingVisualizer::new);
    }
}
