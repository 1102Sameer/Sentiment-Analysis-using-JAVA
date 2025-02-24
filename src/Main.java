import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a review: ");
            String text = scanner.nextLine();
            
            String sentiment = SentimentAnalyzer.analyze(text);
            System.out.println("Sentiment: " + sentiment);
            
            saveToDatabase(text, sentiment);
        }
    }

    private static void saveToDatabase(String text, String sentiment) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn != null) {
                String sql = "INSERT INTO reviews (text, sentiment) VALUES (?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, text);
                stmt.setString(2, sentiment);
                stmt.executeUpdate();
                System.out.println("Saved to database!");
            }
        } catch (Exception e) {
            System.out.println("Error saving data.");
        }
    }
}
