import java.util.ArrayList;
import java.util.List;

// Originator
class Document {
    private String content;

    // Constructor to initialize content
    public Document(String content) {
        this.content = content;
    }

    public void write(String text) {
        this.content += text;
    }

    public String getContent() {
        return this.content;
    }

    // Method to create a memento to store the current state
    public DocumentMemento createMemento() {
        return new DocumentMemento(this.content);
    }

    // Method to restore content from a memento (undo operation)
    public void restoreFromMemento(DocumentMemento memento) {
        this.content = memento.getSavedContent();
    }
}

// Memento: Holds the state of the Document
class DocumentMemento {
    private String content;

    // Constructor to store the document's content
    public DocumentMemento(String content) {
        this.content = content;
    }

    // Getter method to retrieve the saved content
    public String getSavedContent() {
        return this.content;
    }
}

// Caretaker: Responsible for storing mementos and managing undo operations
class History {
    private List<DocumentMemento> mementos;

    // Constructor to initialize the memento list
    public History() {
        this.mementos = new ArrayList<>();
    }

    // Method to add a memento to history
    public void addMemento(DocumentMemento memento) {
        this.mementos.add(memento);
    }

    // Method to get a memento by index (for undo functionality)
    public DocumentMemento getMemento(int index) {
        return this.mementos.get(index);
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a new Document object with initial content
        Document document = new Document("Initial content\n");
        History history = new History();

        // Write some content and save the state
        document.write("Additional content\n");
        history.addMemento(document.createMemento());

        // Write more content and save the state again
        document.write("More content\n");
        history.addMemento(document.createMemento());

        // Print the current content
        System.out.println("Current document content: ");
        System.out.println(document.getContent());

        // Restore to the previous state (undo operation)
        document.restoreFromMemento(history.getMemento(0));

        // Print the document content after undo
        System.out.println("\nAfter undo:");
        System.out.println(document.getContent());
    }
}
