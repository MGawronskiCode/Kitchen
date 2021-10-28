package kitchen;

import kitchen.employees.Chef;
import kitchen.employees.Cook;
import kitchen.employees.KitchenHelper;
import kitchen.logs.Logger;

import java.math.BigDecimal;
import java.util.Date;

public class Kitchen {
  private final Chef chef;
  private final KitchenHelper[] kitchenHelpers = new KitchenHelper[5];
  private final Cook[] cooks = new Cook[2];

  public Kitchen() {
    this.chef = new Chef("Ramsey", new Date(), BigDecimal.valueOf(50000));

    for (int i = 0; i < 5; i++) {
      if (i < 2) {
        cooks[i] = new Cook("Cook " + (i + 1), new Date(), BigDecimal.valueOf(20000));
      }
      kitchenHelpers[i] = new KitchenHelper("Kitchen Helper " + (i + 1), new Date(), BigDecimal.valueOf(10000));
    }
  }

  public void simulation() {
    Logger.addLog("simulation starts.\n\n");
    int simulationTurnsCounter = 0;

    do {
      simulationTurnsCounter++;
      Logger.addLog("simulation round " + simulationTurnsCounter + " starts.");

      Ingredient actualIngredientNeeded = chef.requestRandomIngredient();
      int index = getIndexOfHelperWhoHaveIngredient(actualIngredientNeeded);
      if (index == -1)
        Logger.addLog("Helpers: we don't have " + actualIngredientNeeded + " anymore!");
      else {
        /*Optional<Ingredient> ingredientGiven = */kitchenHelpers[index].giveIngredient(actualIngredientNeeded); // unused
      }
      chef.cook();
      for (Cook cook : cooks)
        cook.cook();
    } while (helpersHaveAnyIngredient());
  }

  private int getIndexOfHelperWhoHaveIngredient(Ingredient ingredient) {
    int indexCounter = 0;

    for (KitchenHelper helper : kitchenHelpers) {
      if (helper.getIngredients().get(ingredient) > 0)
        return indexCounter;
      indexCounter++;
    }
    return -1; //returns -1 if any helper has ingredient
  }

  private boolean helpersHaveAnyIngredient() {
    for (KitchenHelper helper : kitchenHelpers) {
      if (helper.haveAnyIngredient())
        return true;
    }
    return false;
  }
}
