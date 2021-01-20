package connect4.service;

import java.util.Arrays;

public class connect4Status {
    private boolean isWinner;
    private int[] position;
    private String whoWon;

    public connect4Status(boolean isWinner, int[] position, String whoWon) {
        this.isWinner = isWinner;
        this.position = position;
        this.whoWon = whoWon;
    }

    public boolean isWinner() {return isWinner; }

    public void setWinner(boolean winner) {isWinner = winner; }

    public int[] getPosition() {return position;}

    public void setPosition(int[] position) {this.position = position; }

    public String getWhoWon() {return whoWon; }

    public void setWhoWon(String whoWon) {this.whoWon = whoWon;}

    @Override
    public String toString() {
        return "connect4Status{" +
                "isWinner=" + isWinner +
                ", position=" + Arrays.toString(position) +
                ", whoWon='" + whoWon + '\'' +
                '}';
    }
}
