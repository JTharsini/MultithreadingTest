public class SleepOfThread
{
  public static void main(String[]args)
  {
    Runnable runnable = () -> {
      String threadName = Thread.currentThread().getName();
      System.out.println(threadName);
    };
    Runnable runnable2 = () -> {
      String threadName = Thread.currentThread().getName();
      try
      {
        Thread.sleep(2000);
        System.out.println(threadName);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    };
    Thread thread = new Thread(runnable, "JJThread");
    Thread thread2 = new Thread(runnable2, "JJThread2");
    thread.start();
    thread2.start();
  }
}
