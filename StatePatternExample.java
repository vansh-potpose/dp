// State Interface
interface State {
    void insertMoney();
    void selectItem();
    void dispenseItem();
}

// Concrete State: Idle State
class IdleState implements State {
    private VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertMoney() {
        System.out.println("Money inserted.");
        vendingMachine.setState(vendingMachine.getHasMoneyState());
    }

    @Override
    public void selectItem() {
        System.out.println("Please insert money first.");
    }

    @Override
    public void dispenseItem() {
        System.out.println("Please insert money and select an item first.");
    }
}

// Concrete State: Has Money State
class HasMoneyState implements State {
    private VendingMachine vendingMachine;

    public HasMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertMoney() {
        System.out.println("Money already inserted.");
    }

    @Override
    public void selectItem() {
        System.out.println("Item selected.");
        vendingMachine.setState(vendingMachine.getDispensingState());
    }

    @Override
    public void dispenseItem() {
        System.out.println("Please select an item first.");
    }
}

// Concrete State: Dispensing State
class DispensingState implements State {
    private VendingMachine vendingMachine;

    public DispensingState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertMoney() {
        System.out.println("Please wait, dispensing item.");
    }

    @Override
    public void selectItem() {
        System.out.println("Please wait, dispensing item.");
    }

    @Override
    public void dispenseItem() {
        System.out.println("Item dispensed.");
        vendingMachine.setState(vendingMachine.getIdleState());
    }
}

// Context: Vending Machine
class VendingMachine {
    private State idleState;
    private State hasMoneyState;
    private State dispensingState;

    private State currentState;

    public VendingMachine() {
        idleState = new IdleState(this);
        hasMoneyState = new HasMoneyState(this);
        dispensingState = new DispensingState(this);

        currentState = idleState; // Initial state
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public State getIdleState() {
        return idleState;
    }

    public State getHasMoneyState() {
        return hasMoneyState;
    }

    public State getDispensingState() {
        return dispensingState;
    }

    // Actions delegated to the current state
    public void insertMoney() {
        currentState.insertMoney();
    }

    public void selectItem() {
        currentState.selectItem();
    }

    public void dispenseItem() {
        currentState.dispenseItem();
    }
}

// Main class to demonstrate State Pattern
public class StatePatternExample {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        // Idle state: Insert money
        vendingMachine.insertMoney();

        // Has Money state: Select item
        vendingMachine.selectItem();

        // Dispensing state: Dispense item
        vendingMachine.dispenseItem();
    }
}
