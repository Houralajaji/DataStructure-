import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    public LinkedList<String> loadStopWords(String filePath) {
        LinkedList<String> stopWords = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Trim and convert to lowercase to handle any formatting inconsistencies
                stopWords.add(line.trim().toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stopWords;
    }

    public LinkedList<LinkedList<String>> readCSV(String filePath, int rowsToRead, LinkedList<String> stopWords) {
        LinkedList<LinkedList<String>> documents = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int rowIndex = 0;

            // Skip header lines if necessary
            for (int i = 0; i < 2; i++)
                br.readLine();

            while ((line = br.readLine()) != null && rowIndex < rowsToRead) {
                // Split the line by commas or spaces
                String[] words = line.trim().split("[,\\s]+");

                // Create a linked list for the current document
                LinkedList<String> document = new LinkedList<>();

                // Start from index 1, treating the first word as document ID
                for (int i = 1; i < words.length; i++) {
                    // Clean the word by removing quotes and other punctuation
                    String word = words[i].trim().replaceAll("^\"|\"$", "").toLowerCase().replaceAll("\\.", "");

                    // Add word to document only if it's not a stop word and not empty
                    if (!stopWords.contains(word) && !word.isEmpty()) {
                        document.add(word);
                    }
                }

                // Add the document list to documents list
                documents.add(document);
                rowIndex++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return documents;
    }
}
