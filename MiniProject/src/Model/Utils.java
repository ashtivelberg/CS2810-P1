package Model;

public class Utils {

  public static <T> T nullCheck(T data) {
    if (data == null) {
      throw new IllegalArgumentException("Null Value");
    }
    return data;
  }

  public static int parseTimeToMin(String time) {
    int timeInMin = -1;
    try {
      timeInMin = Integer.parseInt(time.substring(0, 2)) * 60;
    } catch (NumberFormatException e) {
      System.out.println("Bad Time Format");
    }
    return timeInMin;
  }

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
