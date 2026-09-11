import java.util.Arrays;

class Player implements Comparable<Player> {
    String name;
    int matchesPlayed;
    double battingAverage;
    boolean injured;
    double fantasyPoints;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
        this.fantasyPoints = battingAverage + matchesPlayed * 2; // custom formula
    }

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10; // experienced players
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured; // newer players must be fit
    }

    @Override
    public int compareTo(Player other) {
        return Double.compare(other.fantasyPoints, this.fantasyPoints); // descending
    }

    static String draftAndRank(Player[] players) {
        Player[] shortlisted = Arrays.stream(players)
            .filter(p -> isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured))
            .toArray(Player[]::new);

        Arrays.sort(shortlisted);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            sb.append((i + 1)).append(". ").append(shortlisted[i].name).append(" | ");
        }
        return sb.toString();
    }
}

public class FantasyDraft {
    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };
        System.out.println(Player.draftAndRank(players));
        // 1. Rahul | 2. Virat | 3. Dev |
    }
}
