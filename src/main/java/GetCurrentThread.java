public class GetCurrentThread
{
  public static void main(String[] args)
  {
    Runnable runnable = () -> {
      String threadName = Thread.currentThread().getName();
      System.out.println(threadName);
    };
    Thread thread = new Thread(runnable, "JJThread");
    Thread thread2 = new Thread(runnable, "JJThread2");
    thread.start();
    thread2.start();
  }
}
