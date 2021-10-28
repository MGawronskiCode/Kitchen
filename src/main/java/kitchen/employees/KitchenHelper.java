package kitchen.employees;

import kitchen.Ingredient;
import kitchen.Randomize;
import kitchen.logs.Logger;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.AbstractMap;
import java.util.Date;
import java.util.EnumMap;
import java.util.Optional;

public class KitchenHelper extends Employee {
  @Getter
  private final AbstractMap<Ingredient, Integer> ingredients;

  public KitchenHelper(String name, Date birthDate, BigDecimal salary) {
    super(name, birthDate, salary);
    ingredients = new EnumMap<>(Ingredient.class);
    addRandomQuantityOfIngredients();
  }

  private void addRandomQuantityOfIngredients() {
    for (Ingredient ingredient : Ingredient.values()) {
      int minimumIngredientQuantity = 0;
      int maximumIngredientQuantity = 3;

      addIngredient(ingredient, Randomize.getRandomIntInRange(minimumIngredientQuantity, maximumIngredientQuantity + 1));
    }
  }

  private void addIngredient(Ingredient ingredient, int quantity) {
    ingredients.put(ingredient, quantity);
  }

  public boolean checkIfHaveIngredient(Ingredient ingredient) {
    return ingredients.getOrDefault(ingredient, 0) > 0;
  }

  public Optional<Ingredient> giveIngredient(Ingredient ingredient) {
    int count = ingredients.getOrDefault(ingredient, 0);
    if (count > 0) {
      ingredients.put(ingredient, count - 1);

      Logger.addLog(this + ": there you go, it's " + ingredient + " you asked for.");
      return Optional.of(ingredient);
    }

    return Optional.empty();
  }

  public boolean haveAnyIngredient(){
    for (Integer integer: ingredients.values()) {
      if (integer > 0)
        return true;
    }
    return false;
  }
}
