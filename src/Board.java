
import java.awt.*;
import javax.swing.JPanel;

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
    
    
    Snake snake;
    Food food;
    
    
    public Board() {
        super();        
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        snake.paint(g2d, getSquareWidth(), getSquareHeight());
        food.paint(g2d);
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
