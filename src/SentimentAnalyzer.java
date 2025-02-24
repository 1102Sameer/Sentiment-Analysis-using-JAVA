public class SentimentAnalyzer {
    public static String analyze(String text) {
        text = text.toLowerCase();
        if (text.contains("good") || text.contains("happy") || text.contains("excellent")) {
            return "Positive";
        } else if (text.contains("bad") || text.contains("sad") || text.contains("terrible")) {
            return "Negative";
        } else {
            return "Neutral";
        }
    }
}
