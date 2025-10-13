import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AlgorithmsMenuPanel extends JPanel {
    public AlgorithmsMenuPanel(final MainMenuFrame frame) {
        setLayout(new GridLayout(2, 3, 20, 20));
        setBorder(BorderFactory.createEmptyBorder(60, 60, 60, 60));
        String[] sorts = {"Quicksort", "Mergesort", "Shell Sort", "Insertion Sort", "Bubble Sort", "Selection Sort"};


        for(int i = 0; i < sorts.length; i++){
            final String sort = sorts[i];
            JButton button = new JButton(sort);
            button.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent action){
                    frame.setContentPane(new DatasetSelectionPanel(frame, sort));
                    frame.revalidate();
                    frame.repaint();
                }
            });
            add(button);
        }
    }
}