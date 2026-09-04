public class ReviewWordProfiler {

    public static void classifyWordLengths(String review) {
        String[] words = review.split("\\s+");
        int shortCount = 0, mediumCount = 0, longCount = 0;

        for (String word : words) {
            int length = word.length();
            if (length >= 1 && length <= 4) shortCount++;
            else if (length <= 8) mediumCount++;
            else longCount++;
        }

        System.out.printf("Short: %d | Medium: %d | Long: %d%n", shortCount, mediumCount, longCount);
    }

    public static void main(String[] args) {
        String review = "This movie was absolutely fantastic and thrilling";
        classifyWordLengths(review);
    }
}
