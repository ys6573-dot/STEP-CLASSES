import java.util.Arrays;

public class FantasyMultiplier {
    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        playerScores[captainIndex] *= 2.0;       // Captain gets double points
        playerScores[viceCaptainIndex] *= 1.5;   // Vice-Captain gets 1.5x points
        System.out.println(Arrays.toString(playerScores));
    }

    public static void main(String[] args) {
        double[] scores = {40, 55, 30, 62};
        applyMultipliers(scores, 1, 3); // [40.0, 110.0, 30.0, 93.0]
    }
}
