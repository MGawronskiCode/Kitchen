package kitchen;

import kitchen.logs.Logger;

public class Main {
  public static void main(String[] args) {
    Logger.addLog("some new log");
    Logger.printLogList();
  }
}
