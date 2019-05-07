
import java.awt.Color;
import java.awt.Graphics2D;
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
public class Snake {
    
    private List<Node> body;
    
    public Snake(int numNodes) {
        
    }
    
    public void paint(Graphics2D g, int squareWidth, int squareHeight) {
        for (Node node: body) {
            Board.drawSquare(g, squareWidth, squareHeight, node.getRow(), node.getCol(), Color.yellow);
        }
    }
}
