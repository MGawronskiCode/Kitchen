package kitchen;

import kitchen.employees.Chef;
import kitchen.employees.Employee;
import kitchen.logs.Logger;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeTest {
  Employee employee = new Chef("picia", new Date(), BigDecimal.valueOf(100));

  @Test
  void test(){
    employee.printTax();
    assertEquals("picia", employee.getName());
    Logger.printLogList();
  }
}