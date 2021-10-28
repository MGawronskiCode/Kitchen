package kitchen.employees;

import kitchen.Ingredient;
import kitchen.Randomize;
import kitchen.logs.Logger;

import java.math.BigDecimal;
import java.util.Date;

public class Chef extends Employee implements Cookable {

  public Chef(String name, Date birthDate, BigDecimal salary) {
    super(name, birthDate, salary);
  }

  @Override
  public void cook() {
    Logger.addLog(this + ": move you dogs!!!");
  }

  public Ingredient requestRandomIngredient() {
    Ingredient[] allIngredientTypes = Ingredient.values();
    int minimumIngredientIndex = 0;
    int maximumIngredientIndex = allIngredientTypes.length;

    int randomIngredientIndex = Randomize.getRandomIntInRange(minimumIngredientIndex, maximumIngredientIndex);
    Ingredient desiredIngredient = allIngredientTypes[randomIngredientIndex];

    requestIngredient(desiredIngredient);

    return desiredIngredient;
  }

  private void requestIngredient(Ingredient desiredIngredient) {
    Logger.addLog(this + ": give me " + desiredIngredient + "! Faster!!");
  }
}
