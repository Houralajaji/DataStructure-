public class InvertedIndexBST {
    private InvertedIndexBSTNode root;

    public InvertedIndexBST() {
        this.root = null;
    }

    public void addWord(String word, int documentId) {
        root = addWordRecursive(root, word, documentId);
    }

    private InvertedIndexBSTNode addWordRecursive(InvertedIndexBSTNode node, String word, int documentId) {
    if (node == null) {
//        System.out.println("Creating new node for word: " + word + " with document ID " + documentId);
        InvertedIndexBSTNode newNode = new InvertedIndexBSTNode(word);
        newNode.addDocumentId(documentId);
        return newNode;
    }

    int comparison = word.compareTo(node.word);
//    System.out.println("Comparing '" + word + "' with '" + node.word + "'");

    if (comparison < 0) {
        node.left = addWordRecursive(node.left, word, documentId);
    } else if (comparison > 0) {
        node.right = addWordRecursive(node.right, word, documentId);
    }
    else {
//        System.out.println("Word '" + word + "' found in BST. Adding document ID " + documentId);
        node.addDocumentId(documentId);
    }

    return node;
}


    public LinkedList<Integer> searchWord(String word) {
        return searchWordRecursive(root, word);
    }

    private LinkedList<Integer> searchWordRecursive(InvertedIndexBSTNode node, String word) {
        if (node == null) {
            return null; // Word not found
        }

        int comparison = word.compareTo(node.word);
        if (comparison < 0) {
            return searchWordRecursive(node.left, word);
        } else if (comparison > 0) {
            return searchWordRecursive(node.right, word);
        } else {
            return node.documentIds; // Word found, return document IDs
        }
    }

    public void printInOrder() {
        printInOrderRecursive(root);
    }

    private void printInOrderRecursive(InvertedIndexBSTNode node) {
        if (node != null) {
            printInOrderRecursive(node.left);
            System.out.println(node.word + ": " + node.documentIds);
            printInOrderRecursive(node.right);
        }
    }
}
