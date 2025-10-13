import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DatasetSelectionPanel extends JPanel {

    public DatasetSelectionPanel(final MainMenuFrame frame, final String sortType) {
        
        setLayout(new GridLayout(1, 3, 20, 20));
        setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        String[] datasets = {"Reversed", "Random", "Nearly Sorted"};


        for(int i = 0; i < datasets.length; i++){

            final String dataset = datasets[i];
            JButton button = new JButton(dataset);


            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame.setContentPane(new SortVisualizerPanel(sortType, dataset));
                    frame.revalidate();
                    frame.repaint();
                }
            });
            add(button);
        }
    }
}