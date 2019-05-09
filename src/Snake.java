
import java.awt.Color;
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
public class Snake {
    
    private List<Node> body;
    private Direction direction;

    public Direction getDirection() {
        return direction;
    }

    public void setRemainingGrow(int remainingGrow) {
        this.remainingGrow = remainingGrow;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    private int remainingGrow;
    
    public Snake(int numNodes) {
        body = new ArrayList<Node>();
        direction = Direction.RIGHT;
        remainingGrow = 0;
        for (int i =0; i< numNodes; i++) {
            body.add(new Node(Config.numRows/2, Config.numCols/2 - i));
        }
                
    }
    
    public void paint(Graphics2D g, int squareWidth, int squareHeight) {
        for (Node node: body) {
            Board.drawSquare(g, squareWidth, squareHeight, node.getRow(), node.getCol(), Color.yellow);
        }
    }
    
    public boolean eat(Food food) {
        if (body.get(0).getRow() == food.getRow() &&
             body.get(0).getCol() == food.getCol() ) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isOnSnake(int row, int col) {
        for (Node node : body) {
            if (row == node.getRow() && col == node.getCol()) {
                return true;
            }
        }
        return false;
    }
    
    public boolean move() {
        int row = body.get(0).getRow();
        int col = body.get(0).getCol();
        switch(direction) {
            case UP: if (direction != Direction.DOWN)
                        return tryToMove(row - 1, col);
                break;
            case DOWN: if (direction != Direction.UP)                    
                        return tryToMove(row + 1, col);
                break;
            case LEFT: if (direction != Direction.RIGHT)                
                            return tryToMove(row, col - 1);
                break;
            case RIGHT: if (direction != Direction.LEFT)
                           return tryToMove(row, col + 1);
                break;
        }
        return true;
    }
    
    public boolean tryToMove(int row, int col) {
        if (row <= 0 || col <= 0 || 
                row >= Config.numRows || col >= Config.numCols) {            
            return false;
        } else {            
            move(row, col);
            return true;
        }
    }
    
    private void move(int row, int col) {
        body.add(0, new Node(row, col));
        if (remainingGrow == 0) {
            body.remove(body.size() - 1);
        } else {
            remainingGrow --;
        }
    }
}
