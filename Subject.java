import java.util.*;
public abstract class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

  abstract public void setState(int state);
  abstract public int getState();
}

class ConcreteSubject extends Subject{
  int state;

  @Override
  public void setState(int state){
    this.state = state;
    notifyObservers();
  }
  @Override
  public int getState() {
   return state;
  }
}


abstract class Observer {
  Subject s;

  Observer(Subject s) {
    this.s = s;
    s.attach(this);
  }
    public abstract void update();
}

class BinaryObserver extends Observer{

   public BinaryObserver(Subject s){
      super(s);
   }

   @Override
   public void update() {
      System.out.println( "Binary String: " + Integer.toBinaryString( s.getState() ) ); 
   }
}

class HexaObserver extends Observer {
   public HexaObserver(Subject s){
      super(s);
   }

   @Override
   public void update() {
      System.out.println( "Hexadecimal String: " + Integer.toHexString( s.getState() ) ); 
   }
}

class OctalObserver extends Observer {
   public OctalObserver(Subject s){
      super(s);
   }

   @Override
   public void update() {
      System.out.println( "Octal String: " + Integer.toOctalString( s.getState() ) ); 
   }
}

class Test {
   public static void main(String[] args) {
      Subject subject = new ConcreteSubject();
      Observer binary = new BinaryObserver(subject);
      Observer hex = new HexaObserver(subject);
     Observer octal = new OctalObserver(subject);

     System.out.println("Current State: " + subject.getState());
     subject.setState(15);
     System.out.println("changed state: " + subject.getState());
   }
}