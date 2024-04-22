import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovingObstacleExample extends JFrame {
    private JPanel gamePanel;
    private Timer timer;
    private int obstacleX = 0; // Initial position of the obstacle

    public MovingObstacleExample() {
        setTitle("Moving Obstacle Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        gamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw your background or other game elements here
                // For example:
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, getWidth(), getHeight());

                // Draw the moving obstacle (you can load an image here)
                g.setColor(Color.ORANGE);
                g.fillRect(obstacleX, getHeight() / 2 - 10, 20, 20);
            }
        };

        add(gamePanel);

        // Create a timer to update the obstacle position
        timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Move the obstacle to the left
                obstacleX += 2;
                if (obstacleX > getWidth()) {
                    obstacleX = -20; // Reset the obstacle position
                }
                gamePanel.repaint();
            }
        });
        timer.start();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MovingObstacleExample());
    }
}
