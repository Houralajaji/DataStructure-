public class InvertedIndexBSTNode {
    String word;
    LinkedList<Integer> documentIds;
    InvertedIndexBSTNode left, right;

    public InvertedIndexBSTNode(String word) {
        this.word = word;
        this.documentIds = new LinkedList<>();
        this.left = this.right = null;
    }

    public void addDocumentId(int documentId) {
        // Debugging output to see if documentId is being added or missed
        if (!documentIds.contains(documentId)) {
//            System.out.println("Adding document ID " + documentId + " for word " + word);
            documentIds.add(documentId);
        }
//        else {
//            System.out.println("Document ID " + documentId + " already exists for word " + word);
//        }
    }
}
