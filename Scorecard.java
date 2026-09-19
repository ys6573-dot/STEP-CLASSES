// Problem 2: The Quiz Scorecard
public class Scorecard {
    private boolean[] results;
    private int countRecorded;

    public Scorecard(int totalQuestions) {
        results = new boolean[totalQuestions];
        countRecorded = 0;
    }

    public void recordAnswer(boolean correct) {
        if (countRecorded < results.length) {
            results[countRecorded] = correct;
            countRecorded++;
        } else {
            System.out.println("Cannot record more answers than total questions.");
        }
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < countRecorded; i++) {
            if (results[i]) score++;
        }
        return score;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println("Final Score = " + sc.getScore());
    }
}