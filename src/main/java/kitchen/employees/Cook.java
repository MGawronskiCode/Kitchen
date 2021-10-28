package kitchen.employees;

import kitchen.logs.Logger;

import java.math.BigDecimal;
import java.util.Date;

public class Cook extends Employee implements Cookable{
  public Cook(String name, Date birthDate, BigDecimal salary) {
    super(name, birthDate, salary);
  }

  @Override
  public void cook() {
    Logger.addLog(this + ": " + "I'm cooking!");
  }
}
