package kitchen;

import java.util.Random;

public class Randomize {
  private Randomize(){}

  private static final Random RANDOM = new Random();

  public static int getRandomIntInRange(int range) {
    return RANDOM.nextInt(range);
  }

  public static int getRandomIntInRange(int min, int max) {
    return RANDOM.nextInt(max - min) + min;
  }
}
