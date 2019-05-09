
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author victor
 */
public class Board extends JPanel {
    
    
    private Snake snake;
    private Food food;
    private Timer timer;
    private MyKeyAdapter keyAdapter;
    
    class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (snake.getDirection() != Direction.RIGHT) {
                        snake.setDirection(Direction.LEFT);
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (snake.getDirection() != Direction.LEFT) {
                        snake.setDirection(Direction.RIGHT);
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (snake.getDirection() != Direction.DOWN) {
                        snake.setDirection(Direction.UP);
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (snake.getDirection() != Direction.UP) {
                        snake.setDirection(Direction.DOWN);
                    }
                    break;                
            }
            repaint();
        }
        
    }
    
    public Board() {
        super();   
        keyAdapter = new MyKeyAdapter();
        addKeyListener(keyAdapter);
        setFocusable(true);
        timer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                tick();
            }
        });
        initGame();
    }
    
    public void initGame() {        
        timer.start();
        snake = new Snake(4);
        food = new Food(snake);
    }
    
    public void tick() {
        snake.move();
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if (snake != null) {
            snake.paint(g2d, getSquareWidth(), getSquareHeight());
        }
        if (food != null) {
            food.paint(g2d, getSquareWidth(), getSquareHeight());    
        }
    }
    
    public int getSquareWidth() {
        return getWidth() / Config.numCols;        
    }
    
    public int getSquareHeight() {
        return getHeight() / Config.numRows;
    }
    
    public static void drawSquare(Graphics2D g, int squareWidth, 
                                int squareHeight, int row, int col, Color color) {
        int x = col * squareWidth;
        int y = row * squareHeight;
        g.setColor(color);
        g.fillRect(x + 1, y + 1, squareWidth - 2, squareHeight - 2);
        g.setColor(color.brighter());
        g.drawLine(x, y + squareHeight - 1, x, y);
        g.drawLine(x, y, x + squareWidth - 1, y);
        g.setColor(color.darker());
        g.drawLine(x + 1, y + squareHeight - 1, x + squareWidth - 1, y + squareHeight - 1);
        g.drawLine(x + squareWidth - 1, y + squareHeight - 1, x + squareWidth - 1, y + 1);
  
    }
    
}
