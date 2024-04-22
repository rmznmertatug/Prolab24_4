import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MazeGenerator extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private static final int CELLS = 50; // Number of cells in each row/column
    private static final int CELL_SIZE = 10;

    private boolean[][] maze;
    private int playerX = 0;
    private int playerY = 0;

    public MazeGenerator() {
        setTitle("Maze Generator");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        generateMaze();

        JPanel mazePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawMaze(g);
                //drawPlayer(g);
            }
        };
        mazePanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        add(mazePanel);
        //addKeyListener(new MazeKeyListener());
        setFocusable(true);
        setVisible(true);
    }

    private void generateMaze() {
        maze = new boolean[CELLS][CELLS];

        // Generate maze (randomly set walls)
        for (int i = 0; i < CELLS; i++) {
            for (int j = 0; j < CELLS; j++) {
                maze[i][j] = Math.random() < 0.2; // Adjust the threshold to change maze density
            }
        }

        // Set entrance and exit
        maze[0][0] = false; // Entrance
        maze[CELLS - 1][CELLS - 1] = false; // Exit
    }

       private void drawMaze(Graphics g) {
        g.setColor(new Color(20,20,150));
        
        for (int i = 0; i < CELLS/2; i++) {
            for (int j = 0; j < CELLS; j++) {
                if (maze[i][j]) {
                    g.fillRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                }
            }
        }
        
        g.setColor(new Color(150,20,20));
        
        for (int i = CELLS/2; i < CELLS; i++) {
            for (int j = 0; j < CELLS; j++) {
                if (maze[i][j]) {
                    g.fillRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                }
            }
        }
    }

//    private void drawPlayer(Graphics g) {
//        if(playerX < CELLS/2)
//        g.setColor(Color.BLUE);
//        else
//          g.setColor(Color.RED);  
//        g.fillOval(playerX * CELL_SIZE, playerY * CELL_SIZE, CELL_SIZE, CELL_SIZE);
//    }

//    private class MazeKeyListener implements KeyListener {
//        @Override
//        public void keyPressed(KeyEvent e) {
//            int key = e.getKeyCode();
//            switch (key) {
//                case KeyEvent.VK_LEFT:
//                    if (playerX > 0 && !maze[playerX - 1][playerY]) {
//                        playerX--;
//                    }
//                    break;
//                case KeyEvent.VK_RIGHT:
//                    if (playerX < CELLS - 1 && !maze[playerX + 1][playerY]) {
//                        playerX++;
//                    }
//                    break;
//                case KeyEvent.VK_UP:
//                    if (playerY > 0 && !maze[playerX][playerY - 1]) {
//                        playerY--;
//                    }
//                    break;
//                case KeyEvent.VK_DOWN:
//                    if (playerY < CELLS - 1 && !maze[playerX][playerY + 1]) {
//                        playerY++;
//                    }
//                    break;
//            }
//            repaint();
//        }
//
//        @Override
//        public void keyTyped(KeyEvent e) {}
//
//        @Override
//        public void keyReleased(KeyEvent e) {}
//    }
    
}

