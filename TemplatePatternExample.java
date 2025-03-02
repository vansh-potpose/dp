// Abstract class defining the template method
abstract class DataProcessor {

    // Template method
    public final void processData() {
        readData();
        processDataFormat();
        saveData();
    }

    // Common method (implemented)
    private void readData() {
        System.out.println("Reading data from source.");
    }

    // Steps to be implemented by subclasses
    protected abstract void processDataFormat();

    // Common method (implemented)
    private void saveData() {
        System.out.println("Saving processed data.");
    }
}

// Concrete Class: Processing XML Data
class XMLDataProcessor extends DataProcessor {
    @Override
    protected void processDataFormat() {
        System.out.println("Processing XML data format.");
    }
}

// Concrete Class: Processing JSON Data
class JSONDataProcessor extends DataProcessor {
    @Override
    protected void processDataFormat() {
        System.out.println("Processing JSON data format.");
    }
}

// Main class to test the Template Design Pattern
public class TemplatePatternExample {
    public static void main(String[] args) {
        DataProcessor xmlProcessor = new XMLDataProcessor();
        xmlProcessor.processData(); // Process XML data

        System.out.println();

        DataProcessor jsonProcessor = new JSONDataProcessor();
        jsonProcessor.processData(); // Process JSON data
    }
}