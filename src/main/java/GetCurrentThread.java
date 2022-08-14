public class GetCurrentThread
{
  public static void main(String[] args)
  {
    Thread thread = new Thread(() -> {
      String threadName = Thread.currentThread().getName();
      System.out.println(threadName);
    }, "JJThread");
    thread.start();
  }
}
