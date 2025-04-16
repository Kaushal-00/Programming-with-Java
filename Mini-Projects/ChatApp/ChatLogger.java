import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ChatLogger {
    private static final String HISTORY_FILE = "chat_history.txt";

    public static void appendToHistory(String message) {
        try (FileWriter fw = new FileWriter(HISTORY_FILE, true)) {
            fw.write(message + "\n");
        } catch (IOException e) {
            System.out.println("Error saving chat history.");
        }
    }

    public static List<String> readHistory() {
        List<String> history = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(HISTORY_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                history.add(line);
            }
        } catch (IOException e) {
            history.add("No previous chat history.");
        }
        return history;
    }
}
