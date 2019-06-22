
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author victor
 */
public class Config {

    public static int numRows = 30;
    public static int numCols = 40;
    public static int score = 0;
    public static boolean withBorders = true;
    private int level;
    private static Config instance = null;
    
    private Config() {
        level = 2;
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

}
