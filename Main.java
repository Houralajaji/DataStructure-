public class Main {
    public static void main(String[] args) {
        // Define file paths and number of rows to read
        String csvFile = "CSC212dataset.csv"; // Replace with your file path
        String stopWordsFile = "stop.txt"; // Replace with your stop words file path
        int rowsToRead = 50; // Number of rows you want to read

        // Create an instance of CSVReader
        CSVReader csvReader = new CSVReader();

        // Load stop words into a LinkedList
        LinkedList<String> stopWords = csvReader.loadStopWords(stopWordsFile);

        // Read the CSV file and store documents in a list of lists
        LinkedList<LinkedList<String>> documents = csvReader.readCSV(csvFile, rowsToRead, stopWords);

        // Print the documents (for demonstration)
        for (int i = 0; i < documents.size(); i++) {
            System.out.println("Document " + i + ": " + documents.get(i));
        }
        
        
        InvertedIndex invertedIndex = new InvertedIndex();

        for (int docId = 0; docId < documents.size(); docId++) {
            LinkedList<String> document = documents.get(docId);
            for (int wordIndex = 0; wordIndex < document.size(); wordIndex++) {
                String word = document.get(wordIndex);
                invertedIndex.addWord(word, docId);
            }
        }

        // Print the inverted index
        System.out.println("Inverted Index:");
        System.out.println(invertedIndex);
        
        InvertedIndexBST invertedIndexBST = new InvertedIndexBST();

        // Add words from documents to the inverted index
        for (int docId = 0; docId < documents.size(); docId++) {
            LinkedList<String> document = documents.get(docId);
            for (int wordIndex = 0; wordIndex < document.size(); wordIndex++) {
                String word = document.get(wordIndex);
                invertedIndexBST.addWord(word, docId);
            }
        }

        // Print the Inverted Index in sorted order
        System.out.println("Inverted Index with BST:");
        invertedIndexBST.printInOrder();


    }
}
