package Model;

/**
 * Utility class for various methods used throughout project
 */
public class Utils {

  /**
   * @param data any data
   * @param <T> any data
   * @return exception if data is null
   */
  public static <T> T nullCheck(T data) {
    if (data == null) {
      throw new IllegalArgumentException("Null Value");
    }
    return data;
  }

  /**
   * @param time String representation of time in hours
   * @return int value of time in minutes
   */
  public static int parseTimeToMin(String time) {
    int timeInMin = -1;
    try {
      timeInMin = Integer.parseInt(time.substring(0, 2)) * 60;
    } catch (NumberFormatException e) {
      System.out.println("Bad Time Format");
    }
    return timeInMin;
  }

  /**
   * @param n int value to compute factorial for
   * @return the factorial of value n
   */
  public static long fact(int n) {
    long factorial = 1;
    int i = 1;
    while (i <= n) {
      factorial *= i;
      i++;
    }
    return factorial;
  }
}
