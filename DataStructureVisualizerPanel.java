import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class DataStructureVisualizerPanel extends JPanel {

    private String dsType;
    private Timer timer;
    private int tick = 0;

    public DataStructureVisualizerPanel(String dsType) {

        this.dsType = dsType;
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(800, 600));


        timer = new Timer(500, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                tick++;
                repaint();
            }
        });

        timer.start();
        setVisible(true);
    }


    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        if (dsType.equals("Linked Lists")) {
            drawLinkedList(g);
        } 
        else if (dsType.equals("Queues")) {
            drawQueue(g);
        } 
        else if (dsType.equals("Trees")) {
            drawTree(g);
        } 
        else if (dsType.equals("Arrays")) {
            drawArray(g);
        } 
        else if (dsType.equals("Hash Tables")) {
            drawHashTable(g);
        } 
        else if (dsType.equals("Sets")) {
            drawSet(g);
        }
    }


    private void drawLinkedList(Graphics g) {

        int x = 50, y = 150;
        for(int i = 0; i < 5; i++){
            g.setColor(Color.CYAN);
            g.fillRect(x, y, 60, 30);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, 60, 30);
            g.drawString("Node " + (i + 1), x + 10, y + 20);
            g.drawLine(x + 60, y + 15, x + 90, y + 15);
            x += 90;
        }

        g.drawString("null", x, y + 20);
    }


    private void drawQueue(Graphics g) {

        int x = 50, y = 150;


        for(int i = 0; i < 5; i++){
            g.setColor(Color.ORANGE);
            g.fillRect(x, y, 60, 30);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, 60, 30);
            g.drawString("Q" + (i + 1), x + 15, y + 20);
            x += 70;
        }


        g.drawString("Front", 50, y - 10);
        g.drawString("Rear", x - 70, y + 50);
    }


    private void drawTree(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        drawTreeNode(g2, "Root", 400, 100, 150);
    }

    private void drawTreeNode(Graphics2D g, String label, int x, int y, int offset) {

        g.setColor(Color.GREEN);
        g.fillOval(x - 20, y - 20, 40, 40);
        g.setColor(Color.BLACK);
        g.drawOval(x - 20, y - 20, 40, 40);
        g.drawString(label, x - 10, y + 5);


        if(offset > 20){
            g.drawLine(x, y + 20, x - offset, y + 80);
            g.drawLine(x, y + 20, x + offset, y + 80);
            drawTreeNode(g, "L", x - offset, y + 80, offset / 2);
            drawTreeNode(g, "R", x + offset, y + 80, offset / 2);
        }
    }

    private void drawArray(Graphics g) {

        int x = 50, y = 150;


        for(int i = 0; i < 10; i++){

            if(i == tick % 10){
                g.setColor(Color.YELLOW);
            } 
            else {
                g.setColor(Color.LIGHT_GRAY);
            }


            g.fillRect(x, y, 50, 50);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, 50, 50);
            g.drawString(String.valueOf(i), x + 20, y + 30);
            x += 60;
        }

        g.drawString("Accessing index " + (tick % 10), 50, y - 20);
    }

    private void drawHashTable(Graphics g) {

        int x = 50, y = 150;


        for(int i = 0; i < 8; i++){

            g.setColor(Color.PINK);
            g.fillRect(x, y, 80, 40);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, 80, 40);
            g.drawString("Bucket " + i, x + 10, y + 25);


            if (i == tick % 8) {
                g.drawString("→ Key " + (i * 3 % 8), x + 10, y + 60);
            }

            x += 100;
        }
    }

    private void drawSet(Graphics g) {

        int x = 100, y = 200;
        g.setColor(Color.MAGENTA);
        g.drawString("Set = { }", x, y);


        for(int i = 0; i < tick % 6; i++){
            g.drawString(String.valueOf(i * 2), x + i * 40, y + 30);
        }
        
        g.drawString("No duplicates allowed", x, y + 60);
    }
}