
import java.awt.Color;
import java.awt.Graphics2D;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author victor
 */
public class Food extends Node {
    public Food(Snake snake) {
        super(0,0);
        int row;
        int col;
        do {
            row = (int) (Math.random() * Config.numRows);
            col = (int) (Math.random() * Config.numCols);
        } while(snake.isOnSnake(row, col));
        setRow(row);
        setCol(col);
    }
    
    public void paint(Graphics2D g2d, int squareWidth, int squareHeight) {
        Board.drawSquare(g2d, squareWidth, squareHeight, getRow(), getCol(), Color.red);
    }
}
