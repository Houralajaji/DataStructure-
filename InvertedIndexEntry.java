public class InvertedIndexEntry {
    private String word;
    private LinkedList<Integer> documentIds;

    public InvertedIndexEntry(String word) {
        this.word = word;
        this.documentIds = new LinkedList<>();
    }

    public String getWord() {
        return word;
    }

    public LinkedList<Integer> getDocumentIds() {
        return documentIds;
    }

    public void addDocumentId(int documentId) {
        // Add only if the document ID is not already in the list
        if (!documentIds.contains(documentId)) {
            documentIds.add(documentId);
        }
    }

    @Override
    public String toString() {
        return word + ": " + documentIds.toString();
    }
}