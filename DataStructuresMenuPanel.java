import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DataStructuresMenuPanel extends JPanel {
    public DataStructuresMenuPanel(final MainMenuFrame frame) {

        setLayout(new GridLayout(2, 3, 20, 20));
        setBorder(BorderFactory.createEmptyBorder(60, 60, 60, 60));
        String[] structures = {"Trees", "Arrays", "Sets", "Hash Tables", "Queues", "Linked Lists"};


        for(int i = 0; i < structures.length; i++){

            final String ds = structures[i];
            JButton button = new JButton(ds);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent action) {
                    frame.setContentPane(new DataStructureVisualizerPanel(ds));
                    frame.revalidate();
                    frame.repaint();
                }
            });
            add(button);
        }
    }
}