/**
 DiceGame - implements rolling two dice, keeping history, and calculating experimental probability
 */
import java.util.ArrayList;
import java.util.Arrays;

public class DiceGame {
    private int d1;
    private int d2;
    private ArrayList<Integer> history;
    /**
     Constructor for a die game with blank history
     */
    public DiceGame() {
        history = new ArrayList<Integer>();
    }
    /**
     Simulate a roll of two dice
     @return the outcome of a roll of two dice
     */
    public int roll() {
        d1 = (int) (Math.random()*6) + 1;
        d2 = (int) (Math.random()*6) + 1;
        int sum = d1+d2;
        history.add(sum);
        return sum;
    }
    /**
     Return roll history as a string
     @return printable history of rolls
     */
    public String getHistory() {
        return history.toString();
    }
    /**
     Return the experimental probability of a roll equal to r
     @param r the outcome to each
     @return the experimental probability of the outcome
     */
    public double getProbability(int r) {
        int count = 0;
        for (int i = 0; i < history.size(); i++) {
            if (history.get(i) == r) {
                count++;
            }
        }
        return (double) count / history.size();
    }
}
