// Subject Interface
interface Database {
    void query(String sql);
}

// RealSubject class that performs the actual work
class RealDatabase implements Database {
    public RealDatabase() {
        // Simulate a time-consuming operation like establishing a connection
        System.out.println("Connecting to the database...");
    }

    @Override
    public void query(String sql) {
        System.out.println("Executing query: " + sql);
    }
}

// Proxy class that controls access to RealDatabase
class DatabaseProxy implements Database {
    private RealDatabase realDatabase;

    @Override
    public void query(String sql) {
        if (realDatabase == null) {
            // Only create the real database when needed
            realDatabase = new RealDatabase();
        }
        realDatabase.query(sql);
    }
}

// Main class to demonstrate Proxy Pattern
public class ProxyPatternExample {
    public static void main(String[] args) {
        Database proxy = new DatabaseProxy();
        System.out.println("Proxy created. No database connection yet.");

        // Query execution triggers database connection
        proxy.query("SELECT * FROM users");
        proxy.query("SELECT * FROM orders");
    }
}
