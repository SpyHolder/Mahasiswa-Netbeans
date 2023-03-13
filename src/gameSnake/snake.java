package gameSnake;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class snake extends javax.swing.JPanel {

    private ular snake;
    private Thread animation;

    public static final int PANEL_WIDTH = 400;
    public static final int PANEL_HEIGHT = 300;
    public static final int AREA_WIDTH
            = PANEL_WIDTH / ular.SNAKE_SIZE;
    public static final int AREA_HEIGHT
            = PANEL_HEIGHT / ular.SNAKE_SIZE;

    public snake() {
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        snake = new ular();
        initThread();
        addKeyListener(new KeyManager());
        setFocusable(true);
        requestFocusInWindow();
        animation.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.addRenderingHints(new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON));
        drawSnake(g2);
    }

    private void drawSnake(Graphics2D g2) {
        Point[] s = snake.getBody();
        int pixel = ular.SNAKE_SIZE;
        // fill the head
        g2.fillOval(s[0].x * pixel, s[0].y * pixel,
                pixel, pixel);
        // draw body outline
        for (int i = 0; i < s.length; i++) {
            g2.drawOval(s[i].x * pixel, s[i].y * pixel,
                    pixel, pixel);
        }
    }

    private void initThread() {
        animation = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        // sleep a while for animation
                        Thread.sleep(300);
                    } catch (InterruptedException ex) {
                    }
                    snake.update();
                    SwingUtilities.invokeLater(
                            new Runnable() {
                        public void run() {
                            repaint();
                        }
                    });
                }
            }
        });
    }

    private class KeyManager extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int c = e.getKeyCode();
            switch (c) {
                case KeyEvent.VK_RIGHT:
                    snake.moveEast();
                    break;
                case KeyEvent.VK_LEFT:
                    snake.moveWest();
                    break;
                case KeyEvent.VK_UP:
                    snake.moveNorth();
                    break;
                case KeyEvent.VK_DOWN:
                    snake.moveSouth();
                    break;
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame f = new JFrame("Snake HQ");
                f.setDefaultCloseOperation(
                        JFrame.EXIT_ON_CLOSE);
                f.add(new snake());
                f.pack();
                f.setResizable(false);
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
