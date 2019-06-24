
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author K501U
 */
public class SpecialFood extends Food {

    private int visibleMilliseconds;
    public static final int MAX_MILLISECONDS = 10000;
    public static final int MIN_MILLISECONDS = 3000;

    public SpecialFood(Snake snake, Wall wall) {
        super(snake, wall);
        visibleMilliseconds = (int) (Math.random() * (MAX_MILLISECONDS - MIN_MILLISECONDS)
                + MIN_MILLISECONDS);
    }

    public void paint(Graphics g, int squareWidth, int squareHeight) {
        Board.drawSquare(g, squareWidth, squareHeight, getRow(), getCol(), Color.blue);
    }
    
    public int getVisibleMilliseconds(){
       return visibleMilliseconds; 
    }

}
