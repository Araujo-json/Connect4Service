package connect4.service;

public class connect4WinningCombo {
    public final int w1,w2,w3,w4;

    public connect4WinningCombo(int w1, int w2, int w3, int w4) {
        this.w1 = w1;
        this.w2 = w2;
        this.w3 = w3;
        this.w4 = w4;
    }

    @Override
    public String toString() {
        return "connect4WinningCombo{" +
                "w1=" + w1 +
                ", w2=" + w2 +
                ", w3=" + w3 +
                ", w4=" + w4 +
                '}';
    }
}
