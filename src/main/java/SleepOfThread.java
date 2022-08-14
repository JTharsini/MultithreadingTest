public class SleepOfThread
{
  public static void main(String[]args)
  {
    Runnable runnable = () -> {
      String threadName = Thread.currentThread().getName();
      System.out.println(threadName + " is started");
      System.out.println(threadName + " is finished");
    };
    Runnable runnable2 = () -> {
      String threadName = Thread.currentThread().getName();
      System.out.println(threadName + " is started");
      try
      {
        Thread.sleep(2000);
        System.out.println(threadName + " is finished");
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
