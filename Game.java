import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Timer;
import javax.swing.*;

public class Game extends JPanel implements Runnable, KeyListener, MouseListener {
    private BufferedImage back;
    private int key;

    private int time = 0;

    private String screen;
   
    public Game() {
        setFocusable(true);
        requestFocusInWindow();
        new Thread(this).start();
        this.addKeyListener(this);
        this.addMouseListener(this);

        key = -1;
    }

    public void run() {
        try {
            while (true) {
                Thread.currentThread().sleep(5);
                repaint();
            }
        } catch (Exception e) {
        }
    }

    public void screen(Graphics g2d) {
        switch (screen) {
            case "PlayerMenu" -> {
                g2d.clearRect(0, 0, getWidth(), getHeight());

              
            }

        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Call the superclass's method to ensure proper painting

        if (back == null) {
            back = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        }

        Graphics2D g2d = back.createGraphics();

        screen(g2d);

        g2d.dispose();
        g.drawImage(back, 0, 0, null);
    }

    // DO NOT DELETE
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    // DO NOT DELETE
    @Override
    public void keyPressed(KeyEvent e) {

    }

    // DO NOT DELETE
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
