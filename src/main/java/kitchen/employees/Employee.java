package kitchen.employees;

import kitchen.logs.Logger;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
public abstract class Employee {
  private final String name;
  private final Date birthDate;
  private final BigDecimal salary;

  protected Employee(String name, Date birthDate, BigDecimal salary) {
    this.name = name;
    this.birthDate = birthDate;
    this.salary = salary;
  }

  public void printTax(){
    Logger.addLog(this.name + "'s tax is: " + salary.multiply(BigDecimal.valueOf(0.99)));
  }

  @Override
  public String toString() {
    return name;
  }
}
