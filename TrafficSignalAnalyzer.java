public class TrafficSignalAnalyzer {

    public static void findLongestStreak(String signalLog) {
        char longestColor = '\0';
        int longestStreak = 0;

        int currentStreak = 1;
        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                currentStreak++;
            } else {
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                    longestColor = signalLog.charAt(i - 1);
                }
                currentStreak = 1;
            }
        }

        // Final check for last streak
        if (currentStreak > longestStreak) {
            longestStreak = currentStreak;
            longestColor = signalLog.charAt(signalLog.length() - 1);
        }

        System.out.printf("Longest Streak: '%c' repeated %d times%n", longestColor, longestStreak);
    }

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
        findLongestStreak("RRRRYYGG");
    }
}
