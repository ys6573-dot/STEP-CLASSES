import java.util.*;

public class RockPaperScissorsGame {
    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};
    private static Random random = new Random();

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) return "Draw";
        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int wins = 0, losses = 0, draws = 0;
        int N = 5;

        System.out.println("Welcome to Rock-Paper-Scissors!");
        System.out.println("Enter Rock, Paper, or Scissors:");

        for (int round = 1; round <= N; round++) {
            String playerMove = sc.nextLine().trim();
            String computerMove = MOVES[random.nextInt(3)];
            String result = playRound(playerMove, computerMove);

            System.out.printf("Round %d — Player: %s, Computer: %s → %s%n",
                    round, playerMove, computerMove, result);

            switch (result) {
                case "Player Wins": wins++; break;
                case "Computer Wins": losses++; break;
                default: draws++;
            }
        }

        double winPercentage = (wins * 100.0) / N;
        System.out.printf("Final Summary: Wins=%d | Losses=%d | Draws=%d | Win %%=%.2f%%%n",
                wins, losses, draws, winPercentage);
    }
}
