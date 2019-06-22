
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
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
    public Timer timer;
    private MyKeyAdapter keyAdapter;
    private ScoreDelegate scoreDelegate;
    public int deltaTime;
    private Wall wall;

    class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
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
        deltaTime = 500;
        timer = new Timer(deltaTime, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                tick();
                repaint();
            }
        });
        initGame();
    }

    public void initGame() {
        snake = new Snake(4);
        food = new Food(snake);
        wall = new Wall();
        timer.start();
    }

    public void setScoreDelegate(ScoreDelegate scoreDelegate) {
        this.scoreDelegate = scoreDelegate;
    }

    public void incrementSpeed() {
        deltaTime -= 100;
    }

    public void tick() {
        if (!snake.move()) {
            gameOver();
        }
        Random random = new Random();
        int num = random.nextInt(3);

        if (snake.eat(food)) {
            scoreDelegate.increment(false);
            snake.setRemainingGrow(1);
            if (scoreDelegate.getScore() % 5 == 0) {
                incrementSpeed();
            }
            food = new Food(snake);
        }

        if (wall.colideWalls(snake, snake.getDirection())) {
            gameOver();
        } else {
        }

        Toolkit.getDefaultToolkit().sync();
    }

    public void gameOver() {
        timer.stop();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        drawBoard(g2d);
        if (snake != null) {
            snake.paint(g2d, getSquareWidth(), getSquareHeight());
        }
        if (food != null) {
            food.paint(g2d, getSquareWidth(), getSquareHeight());
        }

        if (wall != null) {
            wall.drawWall(g, getHeight(), getWidth());
        }
    }

    public int getSquareWidth() {
        return getWidth() / Config.numCols;
    }

    public int getSquareHeight() {
        return getHeight() / Config.numRows;
    }

    public void drawBoard(Graphics2D g) {
        for (int row = 0; row < Config.numRows; row++) {
            for (int col = 0; col < Config.numCols; col++) {
                drawSquare(g, row, col, getSquareWidth(), getSquareHeight(), Color.DARK_GRAY);
            }
        }
    }

    public static void drawSquare(Graphics g, int row, int col, int squareWidth, int squareHeight, Color color) {
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
