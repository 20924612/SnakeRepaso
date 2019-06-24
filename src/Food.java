
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

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

    public Food(Snake snake, Wall wall) {
        super(0, 0);
        boolean collision = true;
        while (collision) {
            int row;
            int col;
            do {
                row = (int) (Math.random() * Config.numRows);
                col = (int) (Math.random() * Config.numCols);
            } while (snake.isOnSnake(row, col));
            setRow(row);
            setCol(col);
            for (Node node : wall.list) {
                if (row == node.getRow() && col == node.getCol()) {
                    collision = true;
                }else{
                    collision = false;
                }
            }
        }
    }

    public void paint(Graphics g, int squareWidth, int squareHeight) {
        Board.drawSquare(g, getRow(), getCol(), squareWidth, squareHeight, Color.green);
    }
}
