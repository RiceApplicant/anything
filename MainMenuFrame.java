import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenuFrame extends JFrame {

    public MainMenuFrame() {

        setTitle("Sorting & Data Structures Visualizer");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton algorithmsButton = new JButton("Algorithms");
        JButton dataStructuresButton = new JButton("Data Structures");


        algorithmsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent action) {
                setContentPane(new AlgorithmsMenuPanel(MainMenuFrame.this));
                revalidate();
                repaint();
            }
        });


        dataStructuresButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent action) {
                setContentPane(new DataStructuresMenuPanel(MainMenuFrame.this));
                revalidate();
                repaint();
            }
        });

        
        JPanel panel = new JPanel(new GridLayout(1, 2, 40, 40));
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.add(algorithmsButton);
        panel.add(dataStructuresButton);
        setContentPane(panel);

        setVisible(true);
    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                new MainMenuFrame();
            }
        });
    }
}