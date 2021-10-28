package kitchen.logs;

import java.util.Date;

public class Log {
  private final String content;
  private final Date date;

  protected Log(String content) {
    this.content = content;
    this.date = new Date();
  }

  @Override
  public String toString() {
    return "@log- " + this.date + ":\t" + content;
  }
}
