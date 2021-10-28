package kitchen.logs;

import java.util.ArrayList;
import java.util.List;

public class Logger {
  private static final List <Log> logList = new ArrayList<>();

  private Logger(){}

  public static void addLog(String logContent){
    logList.add(new Log(logContent));
  }

  public static void printLogList(){
    for (Log log : logList){
      System.out.println(log);
    }
  }
}
