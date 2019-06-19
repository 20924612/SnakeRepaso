/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author victor
 */
public interface ScoreDelegate {
    public void increment(boolean special);
    public void reset();
    public int getScore();
}
