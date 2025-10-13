import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Collections;

public class SortVisualizerPanel extends JPanel {

    private SortAnimator animator;
    private Timer timer;

    public SortVisualizerPanel(String sortType, String datasetType) {

        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(800, 600));
        int[] array = generateDataset(datasetType);
        animator = getAnimator(sortType, array);

        timer = new Timer(50, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (animator.step()) {
                    timer.stop();
                }
                repaint();
            }
        });
        timer.start();
        setVisible(true);
    }

    private int[] generateDataset(String type) {

        Integer[] arr = new Integer[50];
        for(int i = 0; i < arr.length; i++){
            arr[i] = i + 1;
        }

        if(type.equals("Reversed")){
            Arrays.sort(arr, Collections.reverseOrder());
        } 
        else if (type.equals("Random")){
            Collections.shuffle(Arrays.asList(arr));
        } 
        else if (type.equals("Nearly Sorted")){

            for (int i = 0; i < 5; i++) {

                int a = (int) (Math.random() * arr.length);
                int b = (int) (Math.random() * arr.length);
                int temp = arr[a];
                arr[a] = arr[b];
                arr[b] = temp;
            }
        }

        int[] result = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            result[i] = arr[i];
        }
        return result;
    }

    private SortAnimator getAnimator(String type, int[] array) {

        if(type.equals("Bubble Sort")){
            return new BubbleSortAnimator(array);
        } 
        else if (type.equals("Selection Sort")) {
            return new SelectionSortAnimator(array);
        } 
        else if (type.equals("Insertion Sort")) {
            return new InsertionSortAnimator(array);
        } 
        else if (type.equals("Shell Sort")) {
            return new ShellSortAnimator(array);
        } 
        else if (type.equals("MergeSort") || type.equals("Mergesort")) {
            return new MergeSortAnimator(array);
        } 
        else if (type.equals("Quicksort")) {
            return new QuickSortAnimator(array);
        } 
        else {
            throw new IllegalArgumentException("Unknown sort: " + type);
        }
    }

    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        int[] array = animator.getArray();
        int width = getWidth() / array.length;


        for(int i = 0; i < array.length; i++){
            int height = array[i] * 5;
            g.setColor(Color.BLUE);
            g.fillRect(i * width, getHeight() - height, width - 2, height);
        }
    }
}