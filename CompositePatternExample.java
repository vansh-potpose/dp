import java.util.ArrayList;
import java.util.List;

// Component interface
interface Employee {
    void showDetails();
}

// Leaf class representing an individual employee
class Developer implements Employee {
    private String name;
    private String position;

    public Developer(String name, String position) {
        this.name = name;
        this.position = position;
    }
    
    @Override
    public void showDetails() {
        System.out.println("Developer: " + name + ", Position: " + position);
    }
}

// Leaf class representing another individual employee
class Designer implements Employee {
    private String name;
    private String position;

    public Designer(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public void showDetails() {
        System.out.println("Designer: " + name + ", Position: " + position);
    }
}

// Composite class representing a team or department
class Manager implements Employee {
    private String name;
    private String position;
    private List<Employee> subordinates = new ArrayList<>();

    public Manager(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public void addSubordinate(Employee employee) {
        subordinates.add(employee);
    }

    public void removeSubordinate(Employee employee) {
        subordinates.remove(employee);
    }

    @Override
    public void showDetails() {
        System.out.println("Manager: " + name + ", Position: " + position);
        System.out.println("Subordinates:");
        for (Employee employee : subordinates) {
            employee.showDetails();
        }
    }
}

// Main class to demonstrate Composite Pattern
public class CompositePatternExample {
    public static void main(String[] args) {
        // Leaf objects
        Developer dev1 = new Developer("Alice", "Frontend Developer");
        Developer dev2 = new Developer("Bob", "Backend Developer");
        Designer designer1 = new Designer("Charlie", "UI/UX Designer");

        // Composite object
        Manager manager = new Manager("Eve", "Project Manager");

        // Adding subordinates to the manager
        manager.addSubordinate(dev1);
        manager.addSubordinate(dev2);
        manager.addSubordinate(designer1);

        // Displaying the manager's team
        manager.showDetails();
    }
}
