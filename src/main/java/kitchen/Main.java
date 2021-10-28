package kitchen;

import kitchen.logs.Logger;

public class Main {
  public static void main(String[] args) {
    Kitchen kitchen = new Kitchen();
    kitchen.simulation();

    Logger.printLogList();
  }
}
