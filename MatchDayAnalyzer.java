public class MatchDayAnalyzer {
    private static double rowAverage(int[] row) {
        int sum = 0;
        for (int runs : row) sum += runs;
        return (double) sum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            if (avg >= threshold) {
                result.append("Match ").append(i).append(": Power Surge | ");
            } else {
                result.append("Match ").append(i).append(": Normal | ");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[][] runs = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        System.out.println(classifyMatches(runs, 8));
        // Match 0: Normal | Match 1: Power Surge | Match 2: Normal |
    }
}
