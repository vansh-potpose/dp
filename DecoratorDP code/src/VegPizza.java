public class VegPizza extends Pizza{
  double value;

  public VegPizza() {
  description = "VegPizza";
  value=200.0;
 }

public double cost(){
  return value;
 }
}
